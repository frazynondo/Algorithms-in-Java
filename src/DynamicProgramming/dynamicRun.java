package DynamicProgramming;

public class dynamicRun {
    public static void main(String [] args){
        int [] array = {5, 7, -24, 12, 10, 2, 3, 12};
        int [] subset= {5, 12, 3};

        int index = 0;
        for(int I = 0; I< array.length; I++){
          if(array[I] == subset[index]){
              System.out.println(subset[index]);
              index += 1;
          }

          if(index == subset.length){
//              System.out.println("Index is "+ index);
//              break;
              for(int j = 0; j< index; j++){
                  System.out.println("---> "+subset[j]);
              }
              break;
          }

        }
    }
}
