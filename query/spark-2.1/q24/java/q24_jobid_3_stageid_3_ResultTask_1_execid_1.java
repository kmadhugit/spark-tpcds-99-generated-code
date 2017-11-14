/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 016 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 017 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 018 */   private UnsafeRow scan_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 022 */   private UnsafeRow filter_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 025 */   private UnsafeRow project_result;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 028 */
/* 029 */   public GeneratedIterator(Object[] references) {
/* 030 */     this.references = references;
/* 031 */   }
/* 032 */
/* 033 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 034 */     partitionIndex = index;
/* 035 */     this.inputs = inputs;
/* 036 */     wholestagecodegen_init_0();
/* 037 */     wholestagecodegen_init_1();
/* 038 */
/* 039 */   }
/* 040 */
/* 041 */   private void wholestagecodegen_init_0() {
/* 042 */     scan_input = inputs[0];
/* 043 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 044 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 045 */     scan_scanTime1 = 0;
/* 046 */     scan_batch = null;
/* 047 */     scan_batchIdx = 0;
/* 048 */     scan_colInstance0 = null;
/* 049 */     scan_colInstance1 = null;
/* 050 */     scan_colInstance2 = null;
/* 051 */     scan_colInstance3 = null;
/* 052 */     scan_result = new UnsafeRow(4);
/* 053 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 96);
/* 054 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 055 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 056 */     filter_result = new UnsafeRow(4);
/* 057 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 96);
/* 058 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 059 */     project_result = new UnsafeRow(4);
/* 060 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
/* 061 */
/* 062 */   }
/* 063 */
/* 064 */   private void scan_nextBatch() throws java.io.IOException {
/* 065 */     long getBatchStart = System.nanoTime();
/* 066 */     if (scan_input.hasNext()) {
/* 067 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 068 */       scan_numOutputRows.add(scan_batch.numRows());
/* 069 */       scan_batchIdx = 0;
/* 070 */       scan_colInstance0 = scan_batch.column(0);
/* 071 */       scan_colInstance1 = scan_batch.column(1);
/* 072 */       scan_colInstance2 = scan_batch.column(2);
/* 073 */       scan_colInstance3 = scan_batch.column(3);
/* 074 */
/* 075 */     }
/* 076 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 077 */   }
/* 078 */
/* 079 */   private void wholestagecodegen_init_1() {
/* 080 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 081 */
/* 082 */   }
/* 083 */
/* 084 */   protected void processNext() throws java.io.IOException {
/* 085 */     if (scan_batch == null) {
/* 086 */       scan_nextBatch();
/* 087 */     }
/* 088 */     while (scan_batch != null) {
/* 089 */       int numRows = scan_batch.numRows();
/* 090 */       while (scan_batchIdx < numRows) {
/* 091 */         int scan_rowIdx = scan_batchIdx++;
/* 092 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 093 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 094 */
/* 095 */         if (!(!(scan_isNull))) continue;
/* 096 */
/* 097 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 098 */         UTF8String scan_value3 = scan_isNull3 ? null : (scan_colInstance3.getUTF8String(scan_rowIdx));
/* 099 */
/* 100 */         if (!(!(scan_isNull3))) continue;
/* 101 */
/* 102 */         filter_numOutputRows.add(1);
/* 103 */
/* 104 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 105 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 106 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 107 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 108 */         project_holder.reset();
/* 109 */
/* 110 */         project_rowWriter.zeroOutNullBytes();
/* 111 */
/* 112 */         project_rowWriter.write(0, scan_value);
/* 113 */
/* 114 */         if (scan_isNull1) {
/* 115 */           project_rowWriter.setNullAt(1);
/* 116 */         } else {
/* 117 */           project_rowWriter.write(1, scan_value1);
/* 118 */         }
/* 119 */
/* 120 */         if (scan_isNull2) {
/* 121 */           project_rowWriter.setNullAt(2);
/* 122 */         } else {
/* 123 */           project_rowWriter.write(2, scan_value2);
/* 124 */         }
/* 125 */
/* 126 */         project_rowWriter.write(3, scan_value3);
/* 127 */         project_result.setTotalSize(project_holder.totalSize());
/* 128 */         append(project_result);
/* 129 */         if (shouldStop()) return;
/* 130 */       }
/* 131 */       scan_batch = null;
/* 132 */       scan_nextBatch();
/* 133 */     }
/* 134 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 135 */     scan_scanTime1 = 0;
/* 136 */   }
/* 137 */ }
