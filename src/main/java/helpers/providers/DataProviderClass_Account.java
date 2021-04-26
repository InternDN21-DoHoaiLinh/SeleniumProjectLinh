package helpers.providers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import helpers.Constant;
import models.Account;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataProviderClass_Account {
    List<Account> accounts;

    //Data Providers for LOGIN
    @DataProvider(name = "validLoginDataProvider")
    public Object[] getValidLoginJSONData() throws IOException {
        accounts = new ArrayList<>();
        return getJSONData(accounts, Constant.VALID_LOGIN_JSON_DATA_FILE_PATH);
    }

    @DataProvider(name = "invalidLoginDataProvider")
    public Object[] getInvalidLoginJSONData() throws IOException {
        accounts = new ArrayList<>();
        return getJSONData(accounts, Constant.INVALID_LOGIN_JSON_DATA_FILE_PATH);
    }

    //Data Providers for REGISTER
    @DataProvider(name = "validRegisterDataProvider")
    public Object[] getValidRegisterJSONData() throws IOException {
        accounts = new ArrayList<>();
        return getJSONData(accounts, Constant.VALID_REGISTER_JSON_DATA_FILE_PATH);
    }

    //Get JSON Data Method
    public Object[] getJSONData(List<Account> accounts, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        accounts = objectMapper.readValue(new File(filePath)
                , new TypeReference<List<Account>>() {});
        return accounts.toArray();
    }
}
