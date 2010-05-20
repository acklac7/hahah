import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Bulei {
	public Leiqu NumtoLeiqu(int num)
	{
		Leiqu lq=new Leiqu();
		int x=num/10;
		int y=num%10;
		lq.setX(x);
		lq.setY(y);
		return lq;
	}
	public int[] bunumlei()
	{
		int[] leis=new int[10];
		List<Integer> ints=new ArrayList<Integer>();
		for(int i=0;i<100;i++)
		{
			ints.add(i);
		}
		Random rd=new Random();
		for(int i=0;i<10;i++)
		{
			int o=rd.nextInt(ints.size()-1);
			int lei=ints.get(o);
			leis[i]=lei;
			ints.remove(o);
		}
		return leis;
	}
	public int[][] getBuJu(Leiqu[] leis)
	{
		int[][] test=new int[10][10];
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				test[i][j]=0;
				for(int o=0;o<10;o++)
				{
					if(leis[o].getX()==i&&leis[o].getY()==j)
					{
						test[i][j]=-1;
					}
				}
			}
		}
		println(test);
		for(int i=0;i<leis.length;i++)
		{
			List<Leiqu> lqs=new ArrayList<Leiqu>();
			lqs.clear();
			Leiqu lq=leis[i];
			int x=lq.getX();
			int y=lq.getY();
			for(int m=x-1,countx=0;countx<3;m++,countx++)
			{
				for(int j=y-1,county=0;county<3;j++,county++)
				{
					if(m!=x||j!=y)
					{
						Leiqu lqsd=new Leiqu();
						lqsd.setX(m);
						lqsd.setY(j);
						lqs.add(lqsd);
					}
				}
			}
			for(int j=0;j<lqs.size();j++)
			{
				Leiqu tqq=lqs.get(j);
				if(tqq.getX()>=0&&tqq.getY()>=0&&tqq.getX()<=9&&tqq.getY()<=9&&(!isLei(tqq.getX(), tqq.getY(),leis)))
				{
					test[tqq.getX()][tqq.getY()]+=1;
				}
			}
		}
		return test;
	}
	public boolean isLei(int x,int y,Leiqu[] leis)
	{
		boolean islei=false;
		for(int i=0;i<leis.length;i++)
		{
			if(leis[i].getX()==x&&leis[i].getY()==y)
			{
				islei=true;
			}
		}
		return islei;
	}
	public void println(int test[][])
	{
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				System.out.print(test[i][j]+"  ");
			}
			System.out.println();
		}
	}
}
class Leiqu
{
	private int x;
	private int y;
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return y;
	}
}