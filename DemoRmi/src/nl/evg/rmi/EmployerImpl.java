package nl.evg.rmi;

import java.io.*;

public class EmployerImpl implements Serializable
{
  public EmployerImpl(Integer oid)
  {
    this.oid = oid;
  }
  public final Integer oid;

  private static final long serialVersionUID = 1L;
}
