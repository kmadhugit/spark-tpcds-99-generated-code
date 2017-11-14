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
/* 021 */     project_result = new UnsafeRow(5);
/* 022 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 023 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 024 */
/* 025 */   }
/* 026 */
/* 027 */   protected void processNext() throws java.io.IOException {
/* 028 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 029 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 030 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 031 */       double inputadapter_value = inputadapter_isNull ? -1.0 : (inputadapter_row.getDouble(0));
/* 032 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 033 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 034 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 035 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 036 */       byte inputadapter_value3 = inputadapter_row.getByte(3);
/* 037 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 038 */       int inputadapter_value7 = inputadapter_isNull7 ? -1 : (inputadapter_row.getInt(7));
/* 039 */       project_holder.reset();
/* 040 */
/* 041 */       project_rowWriter.zeroOutNullBytes();
/* 042 */
/* 043 */       if (inputadapter_isNull) {
/* 044 */         project_rowWriter.setNullAt(0);
/* 045 */       } else {
/* 046 */         project_rowWriter.write(0, inputadapter_value);
/* 047 */       }
/* 048 */
/* 049 */       if (inputadapter_isNull1) {
/* 050 */         project_rowWriter.setNullAt(1);
/* 051 */       } else {
/* 052 */         project_rowWriter.write(1, inputadapter_value1);
/* 053 */       }
/* 054 */
/* 055 */       if (inputadapter_isNull2) {
/* 056 */         project_rowWriter.setNullAt(2);
/* 057 */       } else {
/* 058 */         project_rowWriter.write(2, inputadapter_value2);
/* 059 */       }
/* 060 */
/* 061 */       project_rowWriter.write(3, inputadapter_value3);
/* 062 */
/* 063 */       if (inputadapter_isNull7) {
/* 064 */         project_rowWriter.setNullAt(4);
/* 065 */       } else {
/* 066 */         project_rowWriter.write(4, inputadapter_value7);
/* 067 */       }
/* 068 */       project_result.setTotalSize(project_holder.totalSize());
/* 069 */       append(project_result);
/* 070 */       if (shouldStop()) return;
/* 071 */     }
/* 072 */   }
/* 073 */ }
