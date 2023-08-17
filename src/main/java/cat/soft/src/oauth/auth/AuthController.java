package cat.soft.src.oauth.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.soft.src.oauth.auth.jwt.JwtTokenProvider;
import cat.soft.src.oauth.user.UsersService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider jwtTokenProvider;
	private final UsersService usersService;
	private final AuthService authService;

	@Autowired
	public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider,
		UsersService usersService, AuthService authService) {
		this.authenticationManager = authenticationManager;
		this.jwtTokenProvider = jwtTokenProvider;
		this.usersService = usersService;
		this.authService = authService;
	}

	//	@PostMapping("/signup")
	//	public BaseResponse<String> join(@RequestBody PostSignupReq postUserReq) throws BaseException {
	//		User user = new User(postUserReq.getEmail());
	//		usersService.createUser(user);
	//		return new BaseResponse<>("회원가입에 성공하였습니다.");
	//	}

	//	@PostMapping("/signin/auto")
	//	public BaseResponse<PostSigninAutoRes> login(@RequestBody PostSigninAutoReq postLoginReq) {
	//		// chk pw
	//		String user_pw = EncryptionUtils.encryptSHA256(postLoginReq.getEmail());
	//
	//		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
	//			postLoginReq.getEmail(), user_pw);
	//		Authentication authentication = authenticationManager.authenticate(authenticationToken);
	//		log.info("유저 인증 . 자동 로그인을 진행합니다.");
	//
	//		PrincipalDetails userEntity = (PrincipalDetails)authentication.getPrincipal();
	//		System.out.println(userEntity);
	//
	//		String user_email = userEntity.getUser().getEmail();
	//		String accessToken = jwtTokenProvider.createAccessToken(user_email);
	//		String refreshToken = jwtTokenProvider.createRefreshToken(user_email);
	//
	//		authService.registerRefreshToken(user_email, refreshToken);
	//		return new BaseResponse<>(new PostSigninAutoRes(accessToken, refreshToken));
	//	}
	//
	//	@GetMapping("/oauth2/success")
	//	public BaseResponse<PostSigninAutoRes> loginSuccess(@RequestParam("accessToken") String accessToken,
	//		@RequestParam("refreshToken") String refreshToken) {
	//		PostSigninAutoRes postLoginRes = new PostSigninAutoRes(accessToken, refreshToken);
	//		return new BaseResponse<>(postLoginRes);
	//	}

}
