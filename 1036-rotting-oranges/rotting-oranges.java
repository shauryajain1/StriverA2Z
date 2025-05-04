class Pair{
    int r,c,sec;
    public Pair(int r,int c,int l)
    {
        this.r = r;
        this.c = c;
        this.sec = l;
    }
}
class Solution {
    private int bfs(int[][] grid,Queue<Pair> q,int cnt)
    {
        int[][] dir = {{0,1}, {1,0}, {0,-1},{-1,0}};
        int made=0;
        int m  =grid.length;
        int n = grid[0].length;
        int sec=0;
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            int r = curr.r, c=curr.c;
            sec=curr.sec; 
            for(int[] d:dir)
            {
                int nr = r+d[0], nc = c+d[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1)
                {
                    q.offer(new Pair(nr,nc,sec+1));
                    grid[nr][nc] = -1;
                    made++;
                }
            }
        }
        if(made==cnt) return sec;
        return -1;
    }
    public int orangesRotting(int[][] grid) {
        int m  =grid.length;
        int n = grid[0].length,cntFresh=0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == 2)
                {
                    q.offer(new Pair(i,j,0));
                    grid[i][j] = -1;
                }
                else if(grid[i][j] == 1)
                cntFresh++;
            }
        }
        return bfs(grid,q,cntFresh);
    }
}