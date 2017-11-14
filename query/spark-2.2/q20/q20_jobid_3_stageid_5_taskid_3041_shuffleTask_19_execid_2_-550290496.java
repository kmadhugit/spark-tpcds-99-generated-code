/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator inputadapter_input;
/* 009 */   private UnsafeRow project_result;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 012 */
/* 013 */   public GeneratedIterator(Object[] references) {
/* 014 */     this.references = references;
/* 015 */   }
/* 016 */
/* 017 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 018 */     partitionIndex = index;
/* 019 */     this.inputs = inputs;
/* 020 */     inputadapter_input = inputs[0];
/* 021 */     project_result = new UnsafeRow(7);
/* 022 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 128);
/* 023 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 7);
/* 024 */
/* 025 */   }
/* 026 */
/* 027 */   protected void processNext() throws java.io.IOException {
/* 028 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 029 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 030 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 031 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 032 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 033 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 034 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 035 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 036 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 037 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 038 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 039 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 040 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 041 */       double inputadapter_value8 = inputadapter_isNull8 ? -1.0 : (inputadapter_row.getDouble(8));
/* 042 */       boolean project_isNull5 = false;
/* 043 */       double project_value5 = -1.0;
/* 044 */       if (inputadapter_isNull8 || inputadapter_value8 == 0) {
/* 045 */         project_isNull5 = true;
/* 046 */       } else {
/* 047 */         boolean project_isNull6 = true;
/* 048 */         double project_value6 = -1.0;
/* 049 */
/* 050 */         boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 051 */         double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 052 */         if (!inputadapter_isNull5) {
/* 053 */           project_isNull6 = false; // resultCode could change nullability.
/* 054 */           project_value6 = inputadapter_value5 * 100.0D;
/* 055 */
/* 056 */         }
/* 057 */         if (project_isNull6) {
/* 058 */           project_isNull5 = true;
/* 059 */         } else {
/* 060 */           project_value5 = (double)(project_value6 / inputadapter_value8);
/* 061 */         }
/* 062 */       }
/* 063 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 064 */       UTF8String inputadapter_value7 = inputadapter_isNull7 ? null : (inputadapter_row.getUTF8String(7));
/* 065 */       project_holder.reset();
/* 066 */
/* 067 */       project_rowWriter.zeroOutNullBytes();
/* 068 */
/* 069 */       if (inputadapter_isNull) {
/* 070 */         project_rowWriter.setNullAt(0);
/* 071 */       } else {
/* 072 */         project_rowWriter.write(0, inputadapter_value);
/* 073 */       }
/* 074 */
/* 075 */       if (inputadapter_isNull1) {
/* 076 */         project_rowWriter.setNullAt(1);
/* 077 */       } else {
/* 078 */         project_rowWriter.write(1, inputadapter_value1);
/* 079 */       }
/* 080 */
/* 081 */       if (inputadapter_isNull2) {
/* 082 */         project_rowWriter.setNullAt(2);
/* 083 */       } else {
/* 084 */         project_rowWriter.write(2, inputadapter_value2);
/* 085 */       }
/* 086 */
/* 087 */       if (inputadapter_isNull3) {
/* 088 */         project_rowWriter.setNullAt(3);
/* 089 */       } else {
/* 090 */         project_rowWriter.write(3, inputadapter_value3);
/* 091 */       }
/* 092 */
/* 093 */       if (inputadapter_isNull4) {
/* 094 */         project_rowWriter.setNullAt(4);
/* 095 */       } else {
/* 096 */         project_rowWriter.write(4, inputadapter_value4);
/* 097 */       }
/* 098 */
/* 099 */       if (project_isNull5) {
/* 100 */         project_rowWriter.setNullAt(5);
/* 101 */       } else {
/* 102 */         project_rowWriter.write(5, project_value5);
/* 103 */       }
/* 104 */
/* 105 */       if (inputadapter_isNull7) {
/* 106 */         project_rowWriter.setNullAt(6);
/* 107 */       } else {
/* 108 */         project_rowWriter.write(6, inputadapter_value7);
/* 109 */       }
/* 110 */       project_result.setTotalSize(project_holder.totalSize());
/* 111 */       append(project_result);
/* 112 */       if (shouldStop()) return;
/* 113 */     }
/* 114 */   }
/* 115 */ }
