# Setup multi factor authentication

Having multi-factor authentication (MFA) for the  user improves security for this account.

By default, every account is secured by username and password. In case of identity theft, attacker can easily use aws services.

MFA in provided in aws by physical device, also called something they have (biometric devices). Login to aws console is finally done by username with password and MFA. 

Enable MFA for your account

- Go to IAM dashboard

- Dashboard will alert you that you have not installed MFA , click on "Add MFA"

- ![Screenshot](../img/iam4.png)

- Find section - "Multi-factor authentication (MFA) and assign MFA device

- Choose Virtual MFA device - app installed in your mobile device which will generate tokens.

- Choose one from the list of compatible applications and install it. (i personally use authy)

- Scan qr by mobile and insert two tokens to fields

- ![Screenshot](../img/iam5.png)


