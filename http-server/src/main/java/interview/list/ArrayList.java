package interview.list;

public class ArrayList implements MyList{

    private int[] arr;

    public ArrayList(int[] arr) {
        this.arr = arr;
    }

    public ArrayList() {
    }

    @Override
    public void insert(int value, int inx) {
            this.arr[inx] = value;
    }


    @Override
    public void iterable() {
        for (int i = 0; i < this.arr.length; i++){
            System.out.println("[" + i + "]" + arr[i]);
        }
    }

    public int[] add(int[] arr, int value){
        int[] extendedArray = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++){
            extendedArray[i] = arr[i];
        }
        extendedArray[extendedArray.length - 1] = value;
        return extendedArray;
    }
    @Override
    public void add(int value){
        int[] thisArr = this.arr;
        if (this.arr == null){
            this.arr = getEmptyArray();
        }
        int[] extendedArray = new int[this.arr.length + 1];
        for (int i = 0; i < this.arr.length; i++){
            extendedArray[i] = thisArr[i];
        }
        extendedArray[extendedArray.length - 1] = value;
        this.arr = extendedArray;
    }

    @Override
    public void delete(int value) {
        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] == value) {
                System.arraycopy(this.arr, i + 1, arr, i, this.arr.length - i - 1);
            }
        }
    }

    @Override
    public int get(int idx) {
        return arr[idx];
    }

    public int[] getEmptyArray(){
        return new int[0];
    }
    public void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println("[" + i + "]" + arr[i]);
        }
    }

}
