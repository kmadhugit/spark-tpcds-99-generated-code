/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator inputadapter_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 010 */   private UnsafeRow filter_result;
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 012 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 013 */   private UnsafeRow project_result;
/* 014 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 015 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 016 */
/* 017 */   public GeneratedIterator(Object[] references) {
/* 018 */     this.references = references;
/* 019 */   }
/* 020 */
/* 021 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 022 */     partitionIndex = index;
/* 023 */     this.inputs = inputs;
/* 024 */     inputadapter_input = inputs[0];
/* 025 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 026 */     filter_result = new UnsafeRow(4);
/* 027 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 64);
/* 028 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 029 */     project_result = new UnsafeRow(1);
/* 030 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 031 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 032 */
/* 033 */   }
/* 034 */
/* 035 */   protected void processNext() throws java.io.IOException {
/* 036 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 037 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 038 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 039 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 040 */
/* 041 */       if (!(!(inputadapter_isNull3))) continue;
/* 042 */
/* 043 */       boolean filter_isNull2 = false;
/* 044 */
/* 045 */       boolean filter_value2 = false;
/* 046 */       filter_value2 = inputadapter_value3 <= 5;
/* 047 */       if (!filter_value2) continue;
/* 048 */
/* 049 */       filter_numOutputRows.add(1);
/* 050 */
/* 051 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 052 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 053 */       project_holder.reset();
/* 054 */
/* 055 */       project_rowWriter.zeroOutNullBytes();
/* 056 */
/* 057 */       if (inputadapter_isNull) {
/* 058 */         project_rowWriter.setNullAt(0);
/* 059 */       } else {
/* 060 */         project_rowWriter.write(0, inputadapter_value);
/* 061 */       }
/* 062 */       project_result.setTotalSize(project_holder.totalSize());
/* 063 */       append(project_result);
/* 064 */       if (shouldStop()) return;
/* 065 */     }
/* 066 */   }
/* 067 */ }
