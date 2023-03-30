def computepay(h, r):
    tot=float(0.00)
    if(int(h)>40):
        mor=int(h)-40;
        tot=tot+float(mor)*float(r)*1.5
        tot=tot+40*float(r)
    else:
        tot=float(r)*float(h);
    return tot
h=input("Enter Hours:")
r=input("Enter Rate:")
p = computepay(h, r)
print ('Pay:',p)