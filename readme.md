# Algorithm Study
## Additional Information
### [Github SSH Simple Guide](https://help.github.com/en/articles/connecting-to-github-with-ssh)
###### Add Identity without Keychain

There may be times in which you don't want the passphrase stored in the keychain, but don't want to have to enter the passphrase over and over again.
You can do that like this:
```bash
ssh-add
or
ssh-add ~/.ssh/id_rsa 
```
This will ask you for the passphrase, enter it and it will not ask again until you restart.

###### Add Identity Using Keychain
As @dennis points out in the comments, to persist the passphrase through restarts by storing it in your keychain, you can use the -K option (-k for Ubuntu) when adding the identity like this:
```bash
ssh-add -K ~/.ssh/id_rsa
```
Once again, this will ask you for the passphrase, enter it and this time it will never ask again for this identity.