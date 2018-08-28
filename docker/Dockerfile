FROM centos:6.6

RUN yum -y install tar cpp binutils glibc glibc-kernheaders glibc-common glibc-devel gcc make gcc-c++ libstdc++-devel tcl

RUN mkdir -p /redis/data && cd /redis

COPY ./redis-3.2.1.tar.gz /redis

RUN cd /redis && tar -xvf redis-3.2.1.tar.gz && rm -rf redis-3.2.1.tar.gz && cd redis-3.2.1

RUN cd /redis/redis-3.2.1 && make && make install

RUN cp /redis/redis-3.2.1/redis.conf /redis/ && echo "daemonize yes" >> redis.conf

VOLUME /redis/data
WORKDIR /redis/data

EXPOSE 6868

ENTRYPOINT ["/usr/local/bin/redis-server","/redis/redis.conf"]