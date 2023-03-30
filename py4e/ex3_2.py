h=input("Enter Hours:")
r=input("Enter Rate:")
sum=float(0.00)
if(int(h)>40):
    mor=int(h)-40;
    sum=sum+float(mor)*float(r)*1.5
    sum=sum+40*float(r)
else:
    sum=float(r)*float(h);
print ('Pay:',sum)