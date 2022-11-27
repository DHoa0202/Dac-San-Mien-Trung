package rrs.model.services; 

import java.util.List;
import java.util.Optional;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rrs.model.entities.Account;
import rrs.model.repositories.AccountRepository;
import rrs.model.utils.SendMail;
import rrs.util.HTMLUtil;
@Service
public class AccountService extends AbstractService<Account, String> {
	
	@Autowired SendMail mail;

	@Override
	protected String getId(Account entity) {
		return entity.getUsername();
	}
	
	public List<Account> getByRole(String role_id) {
		return ((AccountRepository) super.rep).findByRole(role_id);
	}

	public Account getByEmail(String email) {
		return ((AccountRepository) super.rep).getByEmail(email);
	}
	
	/**
	 * <h3>if exist => return account in database</h3>
	 * <h3>else return new account and save into database</h3>
	 * 
	 * @param account to get or save into database
	 * @param sendMail if create account then send email
	 * @return {@link Account} from database
	 * @throws MessagingException 
	 */
	public Account createNotExist(Account account, boolean sendMail){
		if(((AccountRepository) super.rep).getByEmail(account.getEmail()) != null) account.setEmail(null);
		else if(sendMail) try {
			String title = String.format("RRS liên kết tài khoản %s mới", account.getUsername());
			String text = HTMLUtil.newAccount(title, account.getUsername(), account.getPassword(), null);
			mail.sendMimeMessage(title, text, null, RecipientType.TO, account.getEmail());
		} catch (MessagingException e) {}
		
		Optional<Account> o = super.rep.findById(account.getUsername());
		return o.isPresent() ? o.get() : super.rep.save(account);
	}

}
