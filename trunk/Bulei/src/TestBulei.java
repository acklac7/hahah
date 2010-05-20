import junit.framework.TestCase;


public class TestBulei extends TestCase {
	public void test()
	{
		Bulei bu=new Bulei();
		int[] a=new int[10];
		a=bu.bunumlei();
		
		Leiqu[] leis=new Leiqu[10];
		for(int i=0;i<a.length;i++)
		{
			leis[i]=bu.NumtoLeiqu(a[i]);
		}
		int[][] test=bu.getBuJu(leis);
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				System.out.print(test[i][j]+"    ");
			}
			System.out.println();
		}
	}
}
