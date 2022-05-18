package com.practicalUnitTesting;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

// verify that the user gets a new password
// and that the updateUser method of userDAO is called

public class UserServiceImp1Tests {
@Test
   void UserServiceImpShouldSetPassword(){
    // create mocks for the classes we are testing
       String newPassword = "Happy new password";

       User mockUser = mock(User.class);
       UserDAO mockUserDao = mock(UserDAO.class);
       SecurityService mockSecurityService = mock(SecurityService.class);
       UserServiceImpl userServiceImp1 = new UserServiceImpl(mockUserDao, mockSecurityService);

       userServiceImp1.assignPassword(mockUser);

       // verify that the method is called
       verify(mockUserDao).updateUser(mockUser);

       //assertThat(mockUser.getPassword()).isEqualTo(newPassword);
   }


}
