import java.util.*;
class interval{
  public int start;
  public int end;
}
class Main {
	public static void main (String[] args)
	{
		     Scanner sc=new Scanner(System.in);
    System.out.print("Enter no. of elements: ");
    int n=sc.nextInt();
    
    interval currInterval=new interval();
    List<interval>intervals=new ArrayList();
    for(int i=0;i<n;i++)
    {
    interval newInterval = new interval();
      newInterval.start=sc.nextInt();
      newInterval.end=sc.nextInt();
      intervals.add(newInterval);
    }
    
    for(int i=0;i<n;i++)
      {currInterval=intervals.get(i);
      System.out.print("["+currInterval.start+"  "+currInterval.end+"] ");
      }
      System.out.print("Enter the interval to be added: ");
       interval newInterval = new interval();
      newInterval.start=sc.nextInt();
      newInterval.end=sc.nextInt();
      int i=0; boolean merge=false;
      while(i<intervals.size())
      {
          
          currInterval= intervals.get(i); 
          if(newInterval.end<currInterval.start||newInterval.start>currInterval.end)
          {i++;}
          else
          {
              currInterval.start=Math.min(currInterval.start,newInterval.start);
              currInterval.end=Math.max(currInterval.end,newInterval.end);
              intervals.set(i,currInterval);
              merge=true;
              i++;
          }  
        }
        
        if(merge==false)
        { i=0;
          while(i<intervals.size())
          {
            currInterval=intervals.get(i);
            if(currInterval.start>newInterval.end)
            {intervals.add(i,newInterval);break;}
            i++;
          }
        }
        boolean ready;
        do{
        for(i=0;i<intervals.size()-1;i++)
        {
          currInterval=intervals.get(i);
          interval nextInterval=new interval();
          nextInterval=intervals.get(i+1);


          if(currInterval.end>=nextInterval.start)
          {
            nextInterval.start=currInterval.start;
            intervals.set(i+1,nextInterval);
            intervals.remove(i);
          }
        }
ready=true;
        for(i=0;i<intervals.size()-1;i++)
        { 
          currInterval=intervals.get(i);
          interval nextInterval=new interval();
          nextInterval=intervals.get(i+1);
          if(currInterval.end>=nextInterval.start) {ready=false; break;}
        }
        }while(ready==false);
        for(interval e:intervals){System.out.print("["+e.start+" "+e.end+"] ");} 
      
	}
}
