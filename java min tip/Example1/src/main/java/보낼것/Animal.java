package 보낼것;

abstract class Animal {
    public String type(){
        return this.getClass().getSimpleName();
    }

}
