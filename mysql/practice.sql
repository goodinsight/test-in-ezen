use Scott;
show tables;
select * from emp;
select distinct deptno
from emp;
select distinct job, deptno
from emp;
select all job, deptno from emp;
select ename, sal, sal*12+comm, comm
from emp;
select *
from emp
order by empno desc;
select * from emp
order by deptno asc, sal desc;
select distinct job from emp;
select empno as employee_no, ename as employee_name,
mgr as manager, sal as salary, comm as commission, deptno as department_no from emp
order by deptno desc, ename asc;
select * from emp
where empno = 7782;
select * from emp
where deptno = 30 and job = 'salesman';
select * from emp
where deptno = 30 and job = 'SALESMAN';
select * from emp
where empno = 7499 and deptno = 30;
select * from emp
where deptno = 30 or job = 'clerk';
select * from emp
where deptno = 20 or job ='salesman';
select * from emp
where sal >= 2500 and job ='analyst';
select * from emp
where ename <= 'forz';
select * from emp
where not sal = 3000;
select * from emp
where job not in ('manager', 'salesman', 'clerk');
select * from emp
where deptno in (10, 20);
select * from emp
where sal not between 2000 and 3000;
select * from emp
where ename like '___l%';
select * from some_table
where some_column like 'a\_a%';
select * from emp
where sal > null
or comm is null;

select empno, ename, sal, deptno from emp
where deptno = 10
union
select sal, job, deptno, sal from emp
where deptno = 20;

select * from emp where ename like '%S';
select empno, ename, job, sal, deptno from emp
where job = 'salesman' and deptno = 30;
-- select empno, ename, job, sal, deptno from emp
-- where sal >2000 and deptno in(20,30);
select empno, ename, job, sal, deptno from emp
where sal >2000
intersect
select empno, ename, job, sal, deptno from emp
where deptno in(20,30);

select * from emp
where not (sal >= 2000 and sal <= 3000);

select ename, empno, sal, deptno from emp
where (sal <=1000 or sal >=2000) and ename like '%E%' and deptno = 30;

select * from emp
where comm is null and mgr is not null and (job = 'manager' or job = 'clerk') and ename not like '_l%';

select ename, upper(ename), lower(ename) from emp;
select ename, length(ename) from emp
where length(ename)>5;
select * from emp where length(job)>=6;

select job, substr(job,1,2), substring(job, 3, 2), substring(job, 5) from emp;
select job,
substr(job, -length(job)),
substr(job,1, 2),
substr(job, -3)
from emp;
select job, instr(job, 'l') as instr_1 from emp;
select * from emp where instr(ename,'s')>0;
select job, replace(job,'L','l') from emp ;
select job, lpad(job, 3, '=') from emp;
select job, concat(substr(job,1,3),'****') from emp;
select concat(empno, ' : ' , ename) from emp;
select trim(trailing 'ER' from job) from emp;
select mod(floor(avg(sal)), 7) from emp;

select sysdate();
select now();
select hiredate, adddate(hiredate, 111) from emp;
select hiredate, addtime(hiredate, 483612) from emp;
select month(hiredate), monthname(hiredate) from emp;
select hiredate, round(hiredate) from emp;
select concat('ABCD', empno) from emp;
select concat('ABCD',cast(empno as char(5))) from emp;
select *, ifnull(comm, 0) from emp;
select ename, job,if(job != 'sALESMAN', if(job = 'manager', '매니저', '참'), '거짓') as '노세일즈맨' from emp;

select empno, concat(substr(empno,1,2),'**') as masking_empno, ename, concat(substr(ename,1,1),'****')as masking_ename from emp
where length(ename) in (5);
select empno, ename, sal, truncate(sal/21.5, 2) as day_pay, round(sal/21.5/8,1) as time_pay from emp;
select empno, ename, date_format(hiredate, '%Y/%m/%d'), date_format(adddate(hiredate, 90),'%Y-%m-%d'), comm from emp;

select empno, ename, mgr, if(mgr is null, '0000', if(substr(mgr,1,2) = 75, 5555, if(substr(mgr,1,2) = 76, 6666, if(substr(mgr,1,2) = 77, 7777, if(substr(mgr,1,2) =78, 8888, mgr))))) as chg_mgr from emp;

select sum(distinct sal),
		sum(all sal),
        sum(sal)
from emp;

select count(distinct sal),
	count(all sal),
    count(sal)
    from emp;
select count(comm)
from emp
where comm is not null;

select avg(sal), '10' as deptno from emp where deptno = 10
union all
select avg(sal), '20' as deptno from emp where deptno = 20
union all
select avg(sal), '30' as deptno from emp where deptno = 30;

select avg(sal), deptno from emp
group by deptno;
select deptno, job, avg(sal) from emp
group by deptno, job
order by deptno, job;

select deptno, job, avg(sal)
from emp
group by deptno, job
having avg(sal)>=2000
order by deptno, job;

select deptno, job, count(*), max(sal), sum(sal), avg(sal)
from emp
group by deptno, job
order by deptno, job;
select deptno, job, count(*), max(sal), sum(sal), avg(sal)
from emp
group by deptno, job with rollup;

select @@autocommit;
set autocommit = 1;

select e.empno, e.ename, e.sal, d.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno
and sal >= 3000;

select empno as 사원번호, ename as 사원명, sal as 급여, dname as 부서
from emp, dept
where emp.deptno = dept.deptno and sal > (select sal from emp where ename = 'jones');

insert into scott.emp
(empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (7888, 'Lee', null, null, null, null, null, null);

select * from emp;

update emp
set ename ='LEE', job = 'Service'
where empno = 7888;

delete from emp
where empno = 7888;

select empno, ename, sal, dept.deptno, dname
from emp, dept
where emp.deptno = dept.deptno
and sal >= 3000;

select *
from emp e, salgrade s
where e.sal between s.losal and s.hisal;

select e1.empno, e1.ename, e1.JOB, e1.mgr, e2.empno as mgr_empno, e2.ename as mgr_ename
from emp e1 right outer join emp e2
on e1.mgr = e2.empno
order by e1.empno, mgr_empno;

select *
from emp natural join dept
where sal>=3000;

select dept.DEPTNO, dname, empno, ename, sal
from dept, emp
where sal > 2000 and dept.deptno = emp.deptno
order by deptno asc;

select dept.DEPTNO, dname, truncate(avg(sal), 0) as avg_sal, max(sal) as max_sal, min(sal) as min_sal, count(*) as cnt
from dept, emp
where dept.deptno = emp.deptno
group by dept.DEPTNO
order by DEPTNO asc;

select dept.deptno, dname, empno, ename, job, sal
from dept left join emp
on dept.deptno = emp.deptno
order by dept.deptno asc, ename asc;

select dept.deptno, dept.dname, e1.empno, e1.ename, e1.mgr, e1.SAL, e1.DEPTNO as deptno_1, s.LOSAL, s.hisal, s.grade, e1.MGR as mgr_empno, e2.ename as mgr_ename
from emp e1 right outer join dept on dept.deptno = e1.deptno left join emp e2 on e1.mgr = e2.empno, salgrade s
where e1.sal between s.losal and s.hisal
order by deptno, e1.empno;

select dept.deptno, dept.dname, e1.empno, e1.ename, e1.mgr, e1.SAL, e1.DEPTNO as deptno_1, e1.MGR as mgr_empno, e2.ename as mgr_ename
from emp e1 right outer join dept on dept.deptno = e1.DEPTNO left join emp e2 on e1.mgr = e2.empno
order by deptno, e1.empno;

select *
from emp
where sal in (select max(sal) from emp group by deptno);

select max(sal)
from emp
group by deptno;
select *
from emp
where sal = any (select sal from emp where deptno = 30);

select *
from emp
where sal < any (select sal from emp where deptno = 30)
order by sal;

select *
from emp
where exists (select sal from emp where deptno = 50)
order by empno;

select *
from emp
where (deptno, sal) in (select deptno, max(sal) from emp group by deptno);

with
e10 as (select * from emp where deptno = 10),
d as (select * from dept)
select e10.empno, e10.ename, e10.deptno, d.dname, d.loc
from e10, d
where e10.deptno = d.deptno;

select empno, ename, job, sal, (select grade from salgrade where e.sal between losal and hisal) as salgrade, deptno, (select dname from dept where e.deptno = dept.deptno) as dname
from emp e;

select job, empno, ename, sal, emp.deptno, dname
from emp, dept
where emp.deptno = dept.deptno and job = (select job from emp where ename = 'allen')
order by emp.sal desc, emp.ename asc;

select empno, ename, dname, date_format(hiredate, '%Y-%m-%d') as hiredate, loc, sal, salgrade.grade as grade
from emp, dept, salgrade
where emp.deptno = dept.deptno and sal > (select avg(sal) from emp) and emp.sal between salgrade.LOSAL and salgrade.HISAL
order by sal desc, EMPNO;

select empno, ename, job, dept.deptno, dname, loc
from emp, dept
where emp.DEPTNO = dept.deptno and emp.DEPTNO = 10 and job not in (select job from emp where deptno = 30);

select emp.empno, emp.ename, emp.sal, (select grade from salgrade where emp.sal between losal and hisal) as grade
from emp
where sal > all(select sal from emp where job = 'salesman');

create table dept_temp
as select * from dept;
select * from dept_temp;
drop table dept_temp;
insert into dept_temp
(deptno, dname, loc)
values
(50, 'database','seoul');
insert into dept_temp
(deptno, dname, loc)
values
(70, 'web',null);

insert into dept_temp
(deptno, dname, loc)
values
(600, 'network', 'busan');
insert into dept_temp
(deptno, loc)
values
(90, 'INCHEON');

create table emp_temp
as select * from emp where 1<>1;
select * from emp_temp;

insert into emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
select e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno
from emp e, salgrade s
where e.sal between s.LOSAL and s.HISAL
and s.grade = 1;
set sql_safe_updates=0;
update dept_temp
set loc = 'SEOUL'
where deptno = 70;
select * from dept_temp;
rollback;
