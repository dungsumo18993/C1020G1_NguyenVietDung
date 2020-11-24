class Customer{
    constructor(name, cmnd, birthday, email, address, typeService, typeRoom, typeCustomer, discount, quantityIncluded, rendDays) {
        this.name=name;
        this.cmnd=cmnd;
        this.birthday=birthday;
        this.email=email;
        this.address=address;
        this.typeService=typeService;
        this.typeRoom=typeRoom;
        this.typeCustomer=typeCustomer;
        this.discount=discount;
        this.quantityIncluded=quantityIncluded;
        this.rendDays=rendDays;
    }
    getName(){
        return this.name;
    }
    getCmnd(){
        return this.cmnd;
    }
    getBirthday(){
        return this.birthday;
    }
    getEmail(){
        return this.email;
    }
    getAddress(){
        return this.address;
    }
    getTypeService(){
        return this.typeService;
    }
    getTypeRoom(){
        return this.typeRoom;
    }
    getTypeCustomer(){
        return this.typeCustomer;
    }
    getDiscount(){
        return this.discount;
    }
    getQuantityIncluded(){
        return this.quantityIncluded;
    }
    getRendDays(){
        return this.rendDays;
    }
    setName(name){
        this.name=name;
    }
    setCmnd(cmnd){
        this.cmnd=cmnd;
    }
    setBirthDay(birthday){
        this.birthday=birthday;
    }
    setEmail(email){
        this.email=email;
    }
    setAddress(address){
        this.address=address;
    }
    setTypeService(typeservice){
        this.typeService=typeservice;
    }
    setTypeRoom(typeroom){
        this.typeRoom=typeroom;
    }
    setTypeCustomer(typecustomer){
        this.typeCustomer=typecustomer;
    }
    setDiscount(discount){
        this.discount=discount;
    }
    setQuantityIncluded(quantityIncluded){
        this.discount=quantityIncluded;
    }
    setRendDays(rendDays){
        this.rendDays=rendDays;
    }
    totalPays(){
        let money=0;
        if(this.typeService === "Villa"){
            money=500;
        } else if(this.typeService === "House"){
            money=300;
        } else if(this.typeService === "Room"){
            money=100;
        }
        return this.typeService*money*(1-this.discount/100);
    }
}

class Employee {
    constructor(name, cmnd, birthday, email, phone, position, salary) {
        this.name = name;
        this.cmnd = cmnd;
        this.birthday = birthday;
        this.email = email;
        this.phone=phone;
        this.position=position;
        this.salary=0;
    }
    getName(){
        return this.name;
    }
    getCmnd(){
        return this.cmnd;
    }
    getBirthDay(){
        return this.birthday;
    }
    getEmail(){
        return this.email;
    }
    getPhone(){
        return this.phone;
    }
    getPosition(){
        return this.position;
    }
    getSalary(){
        if(this.position==="Manager"){
            this.salary=500;
        } else if(this.position==="Sale"){
            this.salary=300;
        } else if(this.position==="Marketing"){
            this.salary=200;
        }
        return this.salary;
    }
}