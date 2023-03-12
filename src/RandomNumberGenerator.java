class RandomNumberGenerator
{
    public static int generateNumberOfBeds()
    {
        int min = 1;
        int max = 7;

        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }
}