package site.rhys.forum.service.auth.manager.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import site.rhys.forum.common.vo.ResultVo;
import site.rhys.forum.service.auth.manager.UserManager;
import site.rhys.forum.service.user.api.dto.UserDto;
import site.rhys.forum.service.user.api.model.User;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 22:35
 * @since 1.0.0
 */
@Component
@RequestMapping("/fallback/users")
@Slf4j
public class UserManagerFallback implements UserManager {

    @Override
    public ResultVo<User> findById(Long id) {
        log.error("findById: id-> {}", id);
        return ResultVo.create(ResultVo.CODE_CIRCUIT_ERROR, "熔断", null);
    }

    @Override
    public ResultVo<Page<User>> findAll(Pageable pageable) {
        log.error("findById: pageable-> {}", pageable);
        return ResultVo.create(ResultVo.CODE_CIRCUIT_ERROR, "熔断", null);
    }

    @Override
    public ResultVo<User> findByUsername(String username) {
        log.error("findByUsername: username-> {}", username);
        return ResultVo.create(ResultVo.CODE_CIRCUIT_ERROR, "熔断", null);
    }

    @Override
    public ResultVo<User> findByUsernameAndPassword(String username, String password) {
        log.error("findByUsernameAndPassword: username-> {}, password-> {}", username, password);
        return ResultVo.create(ResultVo.CODE_CIRCUIT_ERROR, "熔断", null);
    }

    @Override
    public ResultVo<Page<User>> findAllByUsernameLike(String username, Pageable pageable) {
        log.error("findAllByUsernameLike: username-> {},pageable-> {}", username, pageable);
        return ResultVo.create(ResultVo.CODE_CIRCUIT_ERROR, "熔断", null);
    }

    @Override
    public ResultVo<Page<User>> findAllByNicknameLike(String nickname, Pageable pageable) {
        log.error("findAllByNicknameLike: nickname-> {},pageable-> {}", nickname, pageable);
        return ResultVo.create(ResultVo.CODE_CIRCUIT_ERROR, "熔断", null);
    }

    @Override
    public ResultVo<User> updateSelectionById(Long id, UserDto user) {
        log.error("updateSelectionById: id-> {},user-> {}", id, user);
        return ResultVo.create(ResultVo.CODE_CIRCUIT_ERROR, "熔断", null);
    }

    @Override
    public ResultVo<User> add(UserDto user) {
        log.error("add: user-> {}", user);
        return ResultVo.create(ResultVo.CODE_CIRCUIT_ERROR, "熔断", null);
    }
}
