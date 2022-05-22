package com.homework.banking.service;

import com.homework.banking.dto.type.FlagType;
import com.homework.banking.entity.Account;
import com.homework.banking.entity.AccountHistory;
import com.homework.banking.entity.User;
import com.homework.banking.repository.AccountHistoryRepository;
import com.homework.banking.repository.AccountRepository;
import com.homework.banking.repository.UserRepository;
import com.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CsvService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final AccountHistoryRepository accountHistoryRepository;

    @PostConstruct
    public void csvToDbStart(){
        userCsvToDb();
        accountCsvToDb();
        accountHistoryCsvToDb();
    }

    public int accountCsvToDb(){
        return accountRepository.saveAll(
                getListByCsv("계좌.csv").stream()
                        .map(data -> Account.builder()
                                .userId(data[0])
                                .accountNumber(data[1])
                                .build())
                .collect(Collectors.toList())
        ).size();
    }

    public int userCsvToDb(){
        return userRepository.saveAll(
                getListByCsv("사용자.csv").stream()
                        .map(data -> User.builder()
                                .id(data[0])
                                .name(data[1])
                                .age(Integer.parseInt(data[2].trim()))
                                .createDt(LocalDate.parse(data[3]))
                                .build())
                        .collect(Collectors.toList())
        ).size();
    }

    public int accountHistoryCsvToDb(){
        return accountHistoryRepository.saveAll(
                getListByCsv("계좌내역.csv").stream()
                        .map(data -> AccountHistory.builder()
                                .accountNumber(data[0])
                                .depositWithdrawFlag(FlagType.valueOf(data[1]))
                                .depositAmount(Long.valueOf(data[2]))
                                .depositDt(LocalDate.parse(data[3]))
                                .build())
                        .collect(Collectors.toList())
        ).size();
    }

    @SneakyThrows
    public List<String[]> getListByCsv(String fileName){
        Reader reader = Files.newBufferedReader(Paths.get(
                ClassLoader.getSystemResource("csv/" + fileName).toURI()), StandardCharsets.UTF_8);
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> list = csvReader.readAll();
        reader.close();
        csvReader.close();
        list.remove(0);
        return list;
    }
}
