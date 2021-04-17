public class Numbers {

//test for primality
static boolean isPrime(long n) {
								if (n <= 1)
																return false;
								else if (n <= 3)
																return true;
								else if (n % 3 == 0 || n % 2 == 0)
																return false;
								long i = 5;
								while (i * i <= n) {
																if (n % i == 0 || n % (i + 2) == 0)
																								return false;
																i += 6;
								}
								return true;
}
static boolean isPrime(int n) {
								return isPrime((long) n);
}

public static long totient(long num){  //euler's totient function calculator. returns totient
								long count=0;
								for(long a=1; a<num; a++) { //definition of totient: the amount of numbers less than num coprime to it
																if(GCD(num,a)==1) { //coprime
																								count++;
																}
								}
								return(count);
}
public static long GCD(long a, long b){ //faster euclidean algorithm-see GCD for explanation
								long temp;
								if(a<b) {
																temp=a;
																a=b;
																b=temp;
								}
								if(a%b==0) {
																return(b);
								}
								return(GCD(a%b,b));
}

}
