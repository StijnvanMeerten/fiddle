
public class bigO {

    public static void main( String[] args ) {
        long sum = 0;
        long n = 1000;
        long p = System.currentTimeMillis();

        for( int i = 0; i < n; i++ )   { for( int j = 0; j < n; j++ ){sum++;}}

            System.out.println(System.currentTimeMillis() - p);
    }

    // Fragment 2 for( int i = 0; i < n; i += 2 )    sum++;
    // Fragment 3 for( int i = 0; i < n; i++ )    for( int j = 0; j < n; j++ )        sum++;
    // Fragment 4 for( int i = 0; i < n; i++ )    sum++; for( int j = 0; j < n; j++ )    sum++;
    // Fragment 5 for( int i = 0; i < n; i++ )    for( int j = 0; j < n * n; j++ )        sum++;
    // Fragment 6 for( int i = 0; i < n; i++ )    for( int j = 0; j < i; j++ )        sum++;
    // Fragment 7 for( int i = 0; i < n; i++ )    for( int j = 0; j < n * n; j++ )        for( int k = 0; k < j; k++ )            sum++;
    // Fragment 8 for( int i = 1; i < n; i = i * 2 )    sum++;
}
