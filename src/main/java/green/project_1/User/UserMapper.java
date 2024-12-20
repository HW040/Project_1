package green.project_1.User;


public interface UserMapper {

    //프로젝트 번호로 리더 번호 가져오기
    long leaderNo(long projectNo);
    //스케줄 번호로 실행자 번호 가져오기
    long scheduleUserNoFromSchedule(long scheduleNo);
    //프로젝트 번호로 실행자 번호 가져오기
    long scheduleUserNoFromProject(long projectNo);
}
