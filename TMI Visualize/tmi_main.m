clc;
clear;
close all;

fid = fopen('data.txt');
data = zeros(5,4);
tline = fgetl(fid);
c = 1;
while ischar(tline)
        data(c,:) = str2num(tline);
        c = c +1;
        tline = fgetl(fid);
end
fclose(fid);

fid = fopen('points.txt');
points = zeros(71,2);
tline = fgetl(fid);

c = 1;
while ischar(tline)
        points(c,:) = str2num(tline);
        c = c+1;
        tline = fgetl(fid);
end
fclose(fid);


figure;
points = points * 100.00;
points
data = data * 100.00;
data
cmap = hsv(5);
for n=1:5
    rectangle('Position', [data(n,1), data(n,2), (data(n,3)-data(n,1)), (data(n,4)-data(n,2))],'EdgeColor',cmap(n,:))
    hold on;
end

for n=1:100
    plot(points(n,1), points(n,2),'*');
end



