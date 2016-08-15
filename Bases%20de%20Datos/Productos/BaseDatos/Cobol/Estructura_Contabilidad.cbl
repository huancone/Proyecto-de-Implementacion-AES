	FILE SECTION
	FD AccountTypesFile.
	01 AccountTypes.
		02 AccountTypeID			PIC 9(5).
		02 AccountTypeID			PIC X(15).
		
	FD AccountsFile.
	01 Accounts.
		02 AccountID				PIC 9(5).
		02 AccountNumber			PIC X(10).
		02 AccountName				PIC X(15).
		02 AccountTypeID			PIC 9(5).
		
	FD TransactionsFile.
	01 Transactions.
		02 TransactionID			PIC 9(10).
		02 TransactionNumber		PIC X(10).
		02 TransactionYear			PIC 999.
		02 TransactionMonth			PIC 99.
		02 AccountID				PIC 9(5).
		02 WithdrawalAmount			PIC 9(12).
		02 DepositAmount			PIC 9(12).