package com.aos.account;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceimpl implements AccountService {
	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private HttpSession httpSession;

	@Override
	public String login(Account account) {
		String path = "/aos/login";
		Properties props = new Properties();
		File propsDir = new File("src\\main\\resources" + File.separator + "application.properties");
		try {
			Account result = accountMapper.select(account);
			if (result != null) {
				if (account.getId().equals(result.getId()) && account.getPassword().equals(result.getPassword())) {
					props.load(new FileInputStream(propsDir.getAbsoluteFile()));

					httpSession.setAttribute("Auth_id", account.getId());
					httpSession.setAttribute("storeName",
							new String(props.getProperty("store.name").getBytes("ISO-8859-1"), "utf-8"));
					path = "/aos/main";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;

	}

	@Override
	public void logout() {
		httpSession.invalidate();
	}

}