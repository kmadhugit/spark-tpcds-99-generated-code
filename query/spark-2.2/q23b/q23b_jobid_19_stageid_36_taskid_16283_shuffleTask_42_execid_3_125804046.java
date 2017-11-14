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
/* 021 */     project_result = new UnsafeRow(3);
/* 022 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 023 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 024 */
/* 025 */   }
/* 026 */
/* 027 */   protected void processNext() throws java.io.IOException {
/* 028 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 029 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 030 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 031 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 032 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 033 */       UTF8String inputadapter_value8 = inputadapter_isNull8 ? null : (inputadapter_row.getUTF8String(8));
/* 034 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 035 */       UTF8String inputadapter_value9 = inputadapter_isNull9 ? null : (inputadapter_row.getUTF8String(9));
/* 036 */       project_holder.reset();
/* 037 */
/* 038 */       project_rowWriter.zeroOutNullBytes();
/* 039 */
/* 040 */       if (inputadapter_isNull) {
/* 041 */         project_rowWriter.setNullAt(0);
/* 042 */       } else {
/* 043 */         project_rowWriter.write(0, inputadapter_value);
/* 044 */       }
/* 045 */
/* 046 */       if (inputadapter_isNull8) {
/* 047 */         project_rowWriter.setNullAt(1);
/* 048 */       } else {
/* 049 */         project_rowWriter.write(1, inputadapter_value8);
/* 050 */       }
/* 051 */
/* 052 */       if (inputadapter_isNull9) {
/* 053 */         project_rowWriter.setNullAt(2);
/* 054 */       } else {
/* 055 */         project_rowWriter.write(2, inputadapter_value9);
/* 056 */       }
/* 057 */       project_result.setTotalSize(project_holder.totalSize());
/* 058 */       append(project_result);
/* 059 */       if (shouldStop()) return;
/* 060 */     }
/* 061 */   }
/* 062 */ }
