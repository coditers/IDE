package com.estsoft.codit.ide.util;

import com.estsoft.codit.db.vo.SourceCodeVo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteFile {

  public void write(SourceCodeVo sourceCodeVo, int languageId){
    //경로와 파일명 지정
    int sourceCodeId = sourceCodeVo.getId();
    String filePath = "C:\\sourcecode\\" + sourceCodeId;
    String filename;

    //각 언어별 확장자 셋팅
    if(languageId==1){
      filename = "\\task.c";
    }
    else if(languageId==2){
      filename = "\\task.java";
    }
    else if(languageId==3){
      filename = "\\task.py";
    }
    else{
      filename = "\\task";
    }

    //경로지정,  파일 생성
    try{
      File file = new File(filePath);
      if(file.mkdirs()){
        OutputStream os = new FileOutputStream(filePath+filename);
        byte[] data = sourceCodeVo.getCode().getBytes("UTF-8");
        os.write(data);
      }
      else{
        //여기는 들어오면 안돼
      }
    }
    catch(FileNotFoundException e){
      e.printStackTrace();
    }
    catch(IOException e){
      e.printStackTrace();
    }
  }
}
