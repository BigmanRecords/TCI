package Assignment3tests;

import Assignment3.SecurityService;
import Assignment3.User;
import Assignment3.UserDAO;
import Assignment3.UserServiceImpl;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    @Test
    public void whenAssignPasswordThenUserGetsNewPasswordAndUpdateUserIsCalled() throws Exception{

        //arrange
        UserDAO userDAO = mock(UserDAO.class);
        SecurityService securityService = mock(SecurityService.class);
        User user = mock(User.class);
        String password = "password";

        UserServiceImpl userService = new UserServiceImpl(userDAO,securityService);

        //act
        when(user.getPassword()).thenReturn(password);
        when(securityService.md5(password)).thenReturn(password);

        userService.assignPassword(user);

        //assert
        verify(user).setPassword(password);
        verify(userDAO).updateUser(user);
    }
}
