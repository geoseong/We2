package com.we2.project.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class PjtCtrler {

	/**
     * 해당파일을 copy하는 메소드
     * 
     * @param slc
     *            => 원본파일경로
     * @param tlc
     *            => 복사될파일경로
     * @throws IOException
     */
    public void setFileCopy(File slc, File tlc) throws IOException {
        // ★ 소스가 디렉토리인 경우
        // -->해당 디렉토리의 모든 파일을 타겟 디렉토리에 복사
        if (slc.isDirectory()) {
            if (!tlc.exists()) {
                tlc.mkdir();
            } //end if
  
            String[] children = slc.list();
            for (int i = 0; i < children.length; i++) {
                setFileCopy(new File(slc, children[i]), new File(tlc, children[i]));
            } //end for
            
        } else {
        // ★ 소스가 파일인경우
        	FileInputStream in = new FileInputStream(slc);   // <- 원본파일
            FileOutputStream out = new FileOutputStream(tlc);   // <- 복사될 곳
            long size=0;

		    FileChannel fcin = in.getChannel();
		    FileChannel fcout = out.getChannel();
		
		   //복사될 파일의 사이즈 알아내기
			size=fcin.size();
		
		  // transferTo() 메소드를 이용해서 복사할 파일의 채널을 지정,
		  // 복사할 position은 0부터 파일 크기 만큼
			fcin.transferTo(0, size, fcout);
		
		   fcout.close();
		   fcin.close();
		   out.close();
           in.close();
        } //end if
    } //end setFileCopy
    
	
	public void tempDel(File sourcepaste){
		String temp=sourcepaste.getAbsolutePath();
		System.out.println(temp);
		File remove=new File(temp);
		remove.delete();		
	} //end tempDel(File source)

}
