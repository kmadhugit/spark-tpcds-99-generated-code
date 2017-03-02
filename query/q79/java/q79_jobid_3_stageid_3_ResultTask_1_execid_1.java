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
/* 017 */   private UnsafeRow scan_result;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 021 */   private UnsafeRow filter_result;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 024 */   private UnsafeRow project_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 027 */
/* 028 */   public GeneratedIterator(Object[] references) {
/* 029 */     this.references = references;
/* 030 */   }
/* 031 */
/* 032 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 033 */     partitionIndex = index;
/* 034 */     this.inputs = inputs;
/* 035 */     wholestagecodegen_init_0();
/* 036 */     wholestagecodegen_init_1();
/* 037 */
/* 038 */   }
/* 039 */
/* 040 */   private void wholestagecodegen_init_0() {
/* 041 */     scan_input = inputs[0];
/* 042 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 043 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 044 */     scan_scanTime1 = 0;
/* 045 */     scan_batch = null;
/* 046 */     scan_batchIdx = 0;
/* 047 */     scan_colInstance0 = null;
/* 048 */     scan_colInstance1 = null;
/* 049 */     scan_colInstance2 = null;
/* 050 */     scan_result = new UnsafeRow(3);
/* 051 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 32);
/* 052 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 053 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 054 */     filter_result = new UnsafeRow(3);
/* 055 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 056 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 057 */     project_result = new UnsafeRow(2);
/* 058 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 059 */
/* 060 */   }
/* 061 */
/* 062 */   private void scan_nextBatch() throws java.io.IOException {
/* 063 */     long getBatchStart = System.nanoTime();
/* 064 */     if (scan_input.hasNext()) {
/* 065 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 066 */       scan_numOutputRows.add(scan_batch.numRows());
/* 067 */       scan_batchIdx = 0;
/* 068 */       scan_colInstance0 = scan_batch.column(0);
/* 069 */       scan_colInstance1 = scan_batch.column(1);
/* 070 */       scan_colInstance2 = scan_batch.column(2);
/* 071 */
/* 072 */     }
/* 073 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 074 */   }
/* 075 */
/* 076 */   private void wholestagecodegen_init_1() {
/* 077 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 078 */
/* 079 */   }
/* 080 */
/* 081 */   protected void processNext() throws java.io.IOException {
/* 082 */     if (scan_batch == null) {
/* 083 */       scan_nextBatch();
/* 084 */     }
/* 085 */     while (scan_batch != null) {
/* 086 */       int numRows = scan_batch.numRows();
/* 087 */       while (scan_batchIdx < numRows) {
/* 088 */         int scan_rowIdx = scan_batchIdx++;
/* 089 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 090 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 091 */
/* 092 */         if (!(!(scan_isNull1))) continue;
/* 093 */
/* 094 */         boolean filter_isNull2 = false;
/* 095 */
/* 096 */         boolean filter_value2 = false;
/* 097 */         filter_value2 = scan_value1 >= 200;
/* 098 */         if (!filter_value2) continue;
/* 099 */         boolean filter_isNull5 = false;
/* 100 */
/* 101 */         boolean filter_value5 = false;
/* 102 */         filter_value5 = scan_value1 <= 295;
/* 103 */         if (!filter_value5) continue;
/* 104 */
/* 105 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 106 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 107 */
/* 108 */         if (!(!(scan_isNull))) continue;
/* 109 */
/* 110 */         filter_numOutputRows.add(1);
/* 111 */
/* 112 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 113 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 114 */         project_holder.reset();
/* 115 */
/* 116 */         project_rowWriter.zeroOutNullBytes();
/* 117 */
/* 118 */         project_rowWriter.write(0, scan_value);
/* 119 */
/* 120 */         if (scan_isNull2) {
/* 121 */           project_rowWriter.setNullAt(1);
/* 122 */         } else {
/* 123 */           project_rowWriter.write(1, scan_value2);
/* 124 */         }
/* 125 */         project_result.setTotalSize(project_holder.totalSize());
/* 126 */         append(project_result);
/* 127 */         if (shouldStop()) return;
/* 128 */       }
/* 129 */       scan_batch = null;
/* 130 */       scan_nextBatch();
/* 131 */     }
/* 132 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 133 */     scan_scanTime1 = 0;
/* 134 */   }
/* 135 */ }
