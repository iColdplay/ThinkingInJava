package enumtype;

public enum OzWatch {
    WEST("some place can be hot and dry"),
    NORTH("some where cold and clean"),
    SOUTH("where rainy");
    private String description;
    private OzWatch(String description){
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }
    public static void main(String[] args){
        for(OzWatch d : OzWatch.values()){
                System.out.println(d + "\ndescription=" + d.description);
        }
    }

}
