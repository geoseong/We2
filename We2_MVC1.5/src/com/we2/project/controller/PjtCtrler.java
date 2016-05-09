package com.we2.project.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class PjtCtrler {

	/**
     * �ش������� copy�ϴ� �޼ҵ�
     * 
     * @param slc
     *            => �������ϰ��
     * @param tlc
     *            => ��������ϰ��
     * @throws IOException
     */
    public void setFileCopy(File slc, File tlc) throws IOException {
        // �� �ҽ��� ���丮�� ���
        // -->�ش� ���丮�� ��� ������ Ÿ�� ���丮�� ����
        if (slc.isDirectory()) {
            if (!tlc.exists()) {
                tlc.mkdir();
            } //end if
  
            String[] children = slc.list();
            for (int i = 0; i < children.length; i++) {
                setFileCopy(new File(slc, children[i]), new File(tlc, children[i]));
            } //end for
            
        } else {
        // �� �ҽ��� �����ΰ��
        	FileInputStream in = new FileInputStream(slc);   // <- ��������
            FileOutputStream out = new FileOutputStream(tlc);   // <- ����� ��
            long size=0;

		    FileChannel fcin = in.getChannel();
		    FileChannel fcout = out.getChannel();
		
		   //����� ������ ������ �˾Ƴ���
			size=fcin.size();
		
		  // transferTo() �޼ҵ带 �̿��ؼ� ������ ������ ä���� ����,
		  // ������ position�� 0���� ���� ũ�� ��ŭ
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
