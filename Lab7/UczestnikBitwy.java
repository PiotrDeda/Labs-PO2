interface UczestnikBitwy
{
	static void zatapia(UczestnikBitwy enemy)
	{
		enemy.zatopiony();
	}

	int amunicja();

	void strzelaj();

	void zatopiony();
}