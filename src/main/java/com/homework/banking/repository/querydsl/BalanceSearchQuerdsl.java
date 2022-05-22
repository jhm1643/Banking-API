package com.homework.banking.repository.querydsl;

import com.homework.banking.dto.response.TotalBalanceOfUserResponse;
import com.homework.banking.dto.response.TotalDepositsPerUserAccountResponse;
import com.homework.banking.dto.type.FlagType;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static com.homework.banking.entity.QAccount.account;
import static com.homework.banking.entity.QAccountHistory.accountHistory;
import static com.homework.banking.entity.QUser.user;

@Repository
@RequiredArgsConstructor
public class BalanceSearchQuerdsl {

    private final JPAQueryFactory queryFactory;

    public List<TotalDepositsPerUserAccountResponse> findAccountBalanceByUserId(String userId){
        return queryFactory
                .select(
                        Projections.fields(
                                TotalDepositsPerUserAccountResponse.class,
                                account.accountNumber.as("accountNumber"),
                                getTotalBalance().as("totalBalance")
                                )

                ).from(user)
                .innerJoin(account).on(user.id.eq(account.userId))
                .innerJoin(accountHistory).on(account.accountNumber.eq(accountHistory.accountNumber))
                .where(user.id.eq(userId))
                .groupBy(account.accountNumber)
                .fetch();
    }

    public Long findTotalBalanceByYear(int year){
        return queryFactory
                .select(
                        getTotalBalance()
                ).from(user)
                .innerJoin(account).on(user.id.eq(account.userId))
                .innerJoin(accountHistory).on(account.accountNumber.eq(accountHistory.accountNumber))
                .where(accountHistory.depositDt.between(LocalDate.ofYearDay(year, 1), LocalDate.ofYearDay(year, 365)))
                .fetchOne();
    }

    public List<TotalBalanceOfUserResponse> findAllTotalBalanceOfUserByTerm(LocalDate startDt, LocalDate endDt){
        StringPath totalBalancePath = Expressions.stringPath("totalBalance");
        return queryFactory
                .select(
                        Projections.fields(
                                TotalBalanceOfUserResponse.class,
                                user.id,
                                user.name,
                                getTotalBalance().as("totalBalance")
                        )
                ).from(user)
                .innerJoin(account).on(user.id.eq(account.userId))
                .innerJoin(accountHistory).on(account.accountNumber.eq(accountHistory.accountNumber))
                .where(accountHistory.depositDt.between(startDt, endDt))
                .groupBy(user.id)
                .orderBy(totalBalancePath.desc())
                .fetch();
    }

    private NumberExpression<Long> getTotalBalance(){
        return new CaseBuilder()
                .when(accountHistory.depositWithdrawFlag.eq(FlagType.Y))
                .then(accountHistory.depositAmount.longValue())
                .otherwise(accountHistory.depositAmount.negate())
                .sum();
    }

}
