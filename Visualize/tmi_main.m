clc;
clear;
close all;

fid = fopen('data.txt');
tline = fgetl(fid);
c = 1;
while ischar(tline)
        data(c,:) = str2num(tline);
        c = c +1;
        tline = fgetl(fid);
end
fclose(fid);

fid = fopen('points.txt');
tline = fgetl(fid);

c = 1;
while ischar(tline)
        points(c,:) = str2num(tline);
        c = c+1;
        tline = fgetl(fid);
end
fclose(fid);


figure;


[m,~] = size(data);
cmap = hsv(m+1);
m
data
for n=1:m
    rectangle('Position', [data(n,1), data(n,2), (data(n,3)-data(n,1)), (data(n,4)-data(n,2))],'EdgeColor',cmap(n,:))
    hold on;
end

[m,~] = size(points);
for n=1:m
    plot(points(n,1), points(n,2),'*');
end



