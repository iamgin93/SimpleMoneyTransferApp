"# SimpleMoneyTransferApp" 
SeaMoney has a feature to transfer money between users. Let’s imagine a simple scenario.

 usernames—consisting of lowercase Latin characters—each starts with a balance . Amongst them,  transactions happened, where user transfers  amount of money to . If is larger than the

’s balance when the transaction happens, the transaction is automatically rejected.

Output the final balance of each user.

Input

The first line contains two numbers
 and . Each of the next  following lines contain username   and integer , denoting the balance of user . Following that are  lines, each containing two usernames  and   followed by an integer , denoting the amount of money transferred from  to 

 .

Output

Output the balance of all users in alphabetical order.
SAMPLE INPUT

3 4
amir 10
brenda 10
charlie 10
amir brenda 5
brenda charlie 5
charlie amir 20
charlie amir 7

SAMPLE OUTPUT

amir 12
brenda 10
charlie 8
