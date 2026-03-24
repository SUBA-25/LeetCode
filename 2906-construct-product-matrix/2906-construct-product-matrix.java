class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        long tl[][] =new long[m][n];
        long tr[][] =new long[m][n];
        long bl[][] =new long[m][n];
        long br[][] =new long[m][n];
        long lr[][] =new long[m][n];
        long rl[][] =new long[m][n];
        long tb[][] =new long[m][n];
        long bt[][] =new long[m][n];
        long mod=12345L;


        //lr
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0)lr[i][j]=grid[i][j]%mod;
                else lr[i][j]=(lr[i][j-1]*grid[i][j])%mod;
            }
        }

        //tl
        for(int j=0;j<n;j++){
            long prod=1L;
            for(int i=0;i<m;i++){
                prod=(prod*lr[i][j])%mod;
                tl[i][j]=prod;
            }
        }

        //bl
        for(int j=n-1;j>=0;j--){
            long prod=1L;
            for(int i=m-1;i>=0;i--){
                prod=(prod*lr[i][j])%mod;
                bl[i][j]=prod;
            }
        }

        //rl
        for(int i=0;i<m;i++){
            for(int j=n-1;j>=0;j--){
                if(j==n-1)rl[i][j]=grid[i][j]%mod;
                else rl[i][j]=(rl[i][j+1]*grid[i][j])%mod;
            }
        }

        //tr
        for(int j=0;j<n;j++){
            long prod=1L;
            for(int i=0;i<m;i++){
                prod=(prod*rl[i][j])%mod;
                tr[i][j]=prod;
            }
        }

        //br
        for(int j=n-1;j>=0;j--){
            long prod=1L;
            for(int i=m-1;i>=0;i--){
                prod=(prod*rl[i][j])%mod;
                br[i][j]=prod;
            }
        }

        //tb
        for(int j=0;j<n;j++){
            for(int i=0;i<m;i++){
                if(i==0)tb[i][j]=grid[i][j]%mod;
                else tb[i][j]=(tb[i-1][j]*grid[i][j])%mod;
            }
        }

        //bt
        for(int j=0;j<n;j++){
            for(int i=m-1;i>=0;i--){
                if(i==m-1)bt[i][j]=grid[i][j]%mod;
                else bt[i][j]=(bt[i+1][j]*grid[i][j])%mod;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                long topleft=(i-1<0||j-1<0)?1:tl[i-1][j-1];
                long topright=(i-1<0||j+1>=n)?1:tr[i-1][j+1];
                long bottomleft=(i+1>=m||j-1<0)?1:bl[i+1][j-1];
                long bottomright=(i+1>=m||j+1>=n)?1:br[i+1][j+1];
                long l=(j-1<0)?1:lr[i][j-1],r=(j+1>=n)?1:rl[i][j+1],t=(i-1<0)?1:tb[i-1][j],b=(i+1>=m)?1:bt[i+1][j];
                grid[i][j]=(int)((topleft*topright)%mod);
                grid[i][j]=(int)((grid[i][j]*bottomleft)%mod);
                grid[i][j]=(int)((grid[i][j]*bottomright)%mod);
                grid[i][j]=(int)((grid[i][j]*l)%mod);
                grid[i][j]=(int)((grid[i][j]*r)%mod);
                grid[i][j]=(int)((grid[i][j]*t)%mod);
                grid[i][j]=(int)((grid[i][j]*b)%mod);
            }
        }

        return grid;

    }
}