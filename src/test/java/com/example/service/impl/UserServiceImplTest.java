package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.entity.User_H2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.OptimisticLockingFailureException;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserDao mockUserDao;

    @InjectMocks
    private UserServiceImpl userServiceImplUnderTest;

    @Test
    void testAddUser() {
        // Setup
        final User_H2 user = new User_H2(0, "userName", "address", "phone", Date.valueOf(LocalDate.of(2020, 1, 1)));

        // Configure UserDao.save(...).
        final User_H2 userH2 = new User_H2(0, "userName", "address", "phone", Date.valueOf(LocalDate.of(2020, 1, 1)));
        when(mockUserDao.save(
                new User_H2(0, "userName", "address", "phone", Date.valueOf(LocalDate.of(2020, 1, 1)))))
                .thenReturn(userH2);

        // Run the test
        userServiceImplUnderTest.addUser(user);

        // Verify the results
        verify(mockUserDao).save(
                new User_H2(0, "userName", "address", "phone", Date.valueOf(LocalDate.of(2020, 1, 1))));
    }

    @Test
    void testAddUser_UserDaoThrowsOptimisticLockingFailureException() {
        // Setup
        final User_H2 user = new User_H2(0, "userName", "address", "phone", Date.valueOf(LocalDate.of(2020, 1, 1)));
        when(mockUserDao.save(
                new User_H2(0, "userName", "address", "phone", Date.valueOf(LocalDate.of(2020, 1, 1)))))
                .thenThrow(OptimisticLockingFailureException.class);

        // Run the test
        assertThatThrownBy(() -> userServiceImplUnderTest.addUser(user))
                .isInstanceOf(OptimisticLockingFailureException.class);
    }

    @Test
    void testList() {
        // Setup
        final List<User_H2> expectedResult = List.of(
                new User_H2(0, "userName", "address", "phone", Date.valueOf(LocalDate.of(2020, 1, 1))));

        // Configure UserDao.findAll(...).
        final List<User_H2> userH2s = List.of(
                new User_H2(0, "userName", "address", "phone", Date.valueOf(LocalDate.of(2020, 1, 1))));
        when(mockUserDao.findAll()).thenReturn(userH2s);

        // Run the test
        final List<User_H2> result = userServiceImplUnderTest.list();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testList_UserDaoReturnsNoItems() {
        // Setup
        when(mockUserDao.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<User_H2> result = userServiceImplUnderTest.list();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testFindById() {
        // Setup
        final User_H2 expectedResult = new User_H2(0, "userName", "address", "phone",
                Date.valueOf(LocalDate.of(2020, 1, 1)));

        // Configure UserDao.findById(...).
        final Optional<User_H2> userH = Optional.of(
                new User_H2(0, "userName", "address", "phone", Date.valueOf(LocalDate.of(2020, 1, 1))));
        when(mockUserDao.findById(0)).thenReturn(userH);

        // Run the test
        final User_H2 result = userServiceImplUnderTest.findById(0);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testFindById_UserDaoReturnsAbsent() {
        // Setup
        when(mockUserDao.findById(0)).thenReturn(Optional.empty());

        // Run the test
        final User_H2 result = userServiceImplUnderTest.findById(0);

        // Verify the results
        assertThat(result).isNull();
    }

    @Test
    void testFindByName() {
        // Setup
        final User_H2 expectedResult = new User_H2(0, "userName", "address", "phone",
                Date.valueOf(LocalDate.of(2020, 1, 1)));

        // Configure UserDao.findByUserName(...).
        final User_H2 userH2 = new User_H2(0, "userName", "address", "phone", Date.valueOf(LocalDate.of(2020, 1, 1)));
        when(mockUserDao.findByUserName("name")).thenReturn(userH2);

        // Run the test
        final User_H2 result = userServiceImplUnderTest.findByName("name");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}
