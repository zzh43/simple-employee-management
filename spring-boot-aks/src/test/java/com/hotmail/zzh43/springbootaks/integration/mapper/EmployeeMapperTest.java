package com.hotmail.zzh43.springbootaks.integration.mapper;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;
import static org.assertj.core.api.Assertions.assertThat;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import com.hotmail.zzh43.springbootaks.integration.entity.EmployeeEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeMapperTest {

    private static final Operation DELETE_ALL = deleteAllFrom("employee");

    private static final Operation INSERT_EMPLOYEE
            = insertInto("employee").columns("id",
                                                   "last_name",
                                                   "first_name",
                                                   "full_name",
                                                   "description")
                                          .values(1,
                                                  "一郎",
                                                  "天王洲",
                                                  "天王洲一郎",
                                                  "2020年入社")
                                          .values(2,
                                                  "二郎",
                                                  "天王洲",
                                                  "天王洲二郎",
                                                  "2021年入社")
                                          .build();

    @Autowired
    private EmployeeMapper target;

    @BeforeEach
    void setup() {
        Operation operation = sequenceOf(DELETE_ALL, INSERT_EMPLOYEE);
        DbSetup dbSetup = new DbSetup(new DriverManagerDestination("jdbc:h2:mem:test;MODE=MSSQLServer;DB_CLOSE_DELAY=-1;database_to_upper=false", "sa", "sa"), operation);
        dbSetup.launch();
    }

    @Test
    void test_従業員idを指定して対応する従業員情報を正常に取得できること() {
        // setup
        EmployeeEntity expected = EmployeeEntity.builder()
                                                .id(1)
                                                .lastName("一郎")
                                                .firstName("天王洲")
                                                .fullName("天王洲一郎")
                                                .description("2020年入社")
                                                .build();

        // execute
        EmployeeEntity actual = target.findById(1);

        // assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void test_存在していない従業員idを指定して取得するとnullが返されること() {
        // execute
        EmployeeEntity actual = target.findById(3);

        // assert
        assertThat(actual).isNull();
    }

}