package com.ssafy.pjt1.model.mapper;

import com.ssafy.pjt1.model.dto.comments.Comments;
import com.ssafy.pjt1.model.dto.post.Post;
import com.ssafy.pjt1.model.dto.subscription.Subscription;
import com.ssafy.pjt1.model.dto.user.UserDto;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public UserDto login(UserDto userDto);

    public int join(UserDto userDto);

    public int emailCheck(String user_email);

    public void updateAuthKey(Map<String, String> map);

    public void updateAuthStatus(Map<String, String> map);

    public UserDto userInfo(String user_email);

    public void updatePw(Map<String, String> map);

    public int userModify(UserDto userDto);

    public int userDelete(String user_id);

    public List<Subscription> getSubBoards(String user_id);

    public List<Comments> getComments(String user_id);

    public List<Post> getPosts(String user_id);

    public List<Post> getBookmarks(String user_id);
}