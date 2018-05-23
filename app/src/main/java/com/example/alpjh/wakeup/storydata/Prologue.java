package com.example.alpjh.wakeup.storydata;

import com.example.alpjh.wakeup.StoryActivity;

/**
 * Created by alpjh on 2018-03-07.
 */

public class Prologue {

    public void storySet() {

        StoryActivity.story.add("test message입니다.");
        StoryActivity.story.add("test message 2입니다. \n다른 이미지가 출력됩니다.");
        StoryActivity.story.add("기존 이미지가 출력됩니다.");
        StoryActivity.story.add("이미지1이 출력됩니다.");
        StoryActivity.story.add("게임을 시작합니다");
    }

    public void illSet() {
        StoryActivity.ill.add(0);
        StoryActivity.ill.add(1);
        StoryActivity.ill.add(0);
        StoryActivity.ill.add(1);
        StoryActivity.ill.add(0);


    }

}

/*
    텍스트를 세팅하는 스트링 어레이 하나와
    이미지를 세팅할 시기를 알려주는 인티저 어레이 하나를 만들어서


        */