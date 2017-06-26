package vn.nguyen.service.impl;

import org.fest.assertions.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.modules.junit4.PowerMockRunner;
import vn.nguyen.entity.User;
import vn.nguyen.repository.UserRepository;
import vn.nguyen.request.UserRequest;
import vn.nguyen.service.UserService;

import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by quocnguyen on 28/12/2015.
 */
@RunWith(PowerMockRunner.class)
public class UserServiceImplTest {
    public static final String USER_ID = "userId";
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @Test
    public void testSaveUser() throws Exception {
        UserRequest userRequest = preparedUserRequest();
        when(userRepository.save(Mockito.any(User.class))).thenAnswer(new Answer<User>() {
            public User answer(InvocationOnMock invocationOnMock) throws Throwable {
                return (User)invocationOnMock.getArguments()[0];
            }
        });
        User response = userService.saveUser(userRequest);
        Assertions.assertThat(response.getName()).isEqualTo("Nguyen");
    }

    private UserRequest preparedUserRequest() {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserId("1");
        userRequest.setName("Nguyen");
        userRequest.setAge(30);
        userRequest.setSalary(50.5);
        return userRequest;
    }

    @Test
    public void testUpdateUser() throws Exception {
        UserRequest userRequest = preparedUserRequest();
        when(userRepository.findOne(Mockito.anyString())).thenReturn(preparedUser());
        when(userRepository.save(Mockito.any(User.class))).thenAnswer(new Answer<User>() {
            public User answer(InvocationOnMock invocationOnMock) throws Throwable {
                return (User)invocationOnMock.getArguments()[0];
            }
        });
        User userResponse = userService.updateUser(userRequest);
        Assertions.assertThat(userResponse.getAge()).isEqualTo(30);
    }

    private User preparedUser() {
        User user = new User();
        user.setUserid(USER_ID);
        user.setAge(31);
        user.setSalary(50.5);
        user.setName("Nguyen");
        return user;
    }
}