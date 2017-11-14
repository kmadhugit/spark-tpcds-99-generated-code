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
/* 021 */   private scala.collection.immutable.Set filter_hset;
/* 022 */   private boolean filter_hasNull;
/* 023 */   private UnsafeRow filter_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 026 */   private UnsafeRow project_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 029 */
/* 030 */   public GeneratedIterator(Object[] references) {
/* 031 */     this.references = references;
/* 032 */   }
/* 033 */
/* 034 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 035 */     partitionIndex = index;
/* 036 */     this.inputs = inputs;
/* 037 */     wholestagecodegen_init_0();
/* 038 */     wholestagecodegen_init_1();
/* 039 */
/* 040 */   }
/* 041 */
/* 042 */   private void wholestagecodegen_init_0() {
/* 043 */     scan_input = inputs[0];
/* 044 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 045 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 046 */     scan_scanTime1 = 0;
/* 047 */     scan_batch = null;
/* 048 */     scan_batchIdx = 0;
/* 049 */     scan_colInstance0 = null;
/* 050 */     scan_colInstance1 = null;
/* 051 */     scan_colInstance2 = null;
/* 052 */     scan_result = new UnsafeRow(3);
/* 053 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 054 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 055 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 056 */     filter_hset = ((org.apache.spark.sql.catalyst.expressions.InSet)references[3]).getHSet();
/* 057 */     filter_hasNull = filter_hset.contains(null);
/* 058 */     filter_result = new UnsafeRow(3);
/* 059 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 060 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
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
/* 073 */
/* 074 */     }
/* 075 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 076 */   }
/* 077 */
/* 078 */   private void wholestagecodegen_init_1() {
/* 079 */     project_result = new UnsafeRow(2);
/* 080 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 081 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 082 */
/* 083 */   }
/* 084 */
/* 085 */   protected void processNext() throws java.io.IOException {
/* 086 */     if (scan_batch == null) {
/* 087 */       scan_nextBatch();
/* 088 */     }
/* 089 */     while (scan_batch != null) {
/* 090 */       int scan_numRows = scan_batch.numRows();
/* 091 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 092 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 093 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 094 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 095 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 096 */
/* 097 */         boolean filter_isNull = scan_isNull1;
/* 098 */         boolean filter_value = false;
/* 099 */         if (!filter_isNull) {
/* 100 */           filter_value = filter_hset.contains(scan_value1);
/* 101 */           if (!filter_value && filter_hasNull) {
/* 102 */             filter_isNull = true;
/* 103 */           }
/* 104 */         }
/* 105 */         if (filter_isNull || !filter_value) continue;
/* 106 */
/* 107 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 108 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 109 */
/* 110 */         if (!(!(scan_isNull))) continue;
/* 111 */
/* 112 */         filter_numOutputRows.add(1);
/* 113 */
/* 114 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 115 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 116 */         project_rowWriter.zeroOutNullBytes();
/* 117 */
/* 118 */         project_rowWriter.write(0, scan_value);
/* 119 */
/* 120 */         if (scan_isNull2) {
/* 121 */           project_rowWriter.setNullAt(1);
/* 122 */         } else {
/* 123 */           project_rowWriter.write(1, scan_value2);
/* 124 */         }
/* 125 */         append(project_result);
/* 126 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 127 */       }
/* 128 */       scan_batchIdx = scan_numRows;
/* 129 */       scan_batch = null;
/* 130 */       scan_nextBatch();
/* 131 */     }
/* 132 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 133 */     scan_scanTime1 = 0;
/* 134 */   }
/* 135 */ }
