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
/* 015 */   private UnsafeRow scan_result;
/* 016 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 019 */   private scala.collection.immutable.Set filter_hset;
/* 020 */   private boolean filter_hasNull;
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
/* 048 */     scan_result = new UnsafeRow(1);
/* 049 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 32);
/* 050 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 1);
/* 051 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 052 */     filter_hset = ((org.apache.spark.sql.catalyst.expressions.InSet)references[3]).getHSet();
/* 053 */     filter_hasNull = filter_hset.contains(null);
/* 054 */     filter_result = new UnsafeRow(1);
/* 055 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 056 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 1);
/* 057 */     project_result = new UnsafeRow(1);
/* 058 */
/* 059 */   }
/* 060 */
/* 061 */   private void scan_nextBatch() throws java.io.IOException {
/* 062 */     long getBatchStart = System.nanoTime();
/* 063 */     if (scan_input.hasNext()) {
/* 064 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 065 */       scan_numOutputRows.add(scan_batch.numRows());
/* 066 */       scan_batchIdx = 0;
/* 067 */       scan_colInstance0 = scan_batch.column(0);
/* 068 */
/* 069 */     }
/* 070 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 071 */   }
/* 072 */
/* 073 */   private void wholestagecodegen_init_1() {
/* 074 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 075 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 076 */
/* 077 */   }
/* 078 */
/* 079 */   protected void processNext() throws java.io.IOException {
/* 080 */     if (scan_batch == null) {
/* 081 */       scan_nextBatch();
/* 082 */     }
/* 083 */     while (scan_batch != null) {
/* 084 */       int numRows = scan_batch.numRows();
/* 085 */       while (scan_batchIdx < numRows) {
/* 086 */         int scan_rowIdx = scan_batchIdx++;
/* 087 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 088 */         UTF8String scan_value = scan_isNull ? null : (scan_colInstance0.getUTF8String(scan_rowIdx));
/* 089 */
/* 090 */         boolean filter_isNull1 = true;
/* 091 */         UTF8String filter_value1 = null;
/* 092 */
/* 093 */         if (!scan_isNull) {
/* 094 */           filter_isNull1 = false; // resultCode could change nullability.
/* 095 */           filter_value1 = scan_value.substringSQL(1, 5);
/* 096 */
/* 097 */         }
/* 098 */         boolean filter_isNull = filter_isNull1;
/* 099 */         boolean filter_value = false;
/* 100 */         if (!filter_isNull) {
/* 101 */           filter_value = filter_hset.contains(filter_value1);
/* 102 */           if (!filter_value && filter_hasNull) {
/* 103 */             filter_isNull = true;
/* 104 */           }
/* 105 */         }
/* 106 */         if (filter_isNull || !filter_value) continue;
/* 107 */
/* 108 */         filter_numOutputRows.add(1);
/* 109 */
/* 110 */         boolean project_isNull = true;
/* 111 */         UTF8String project_value = null;
/* 112 */
/* 113 */         if (!scan_isNull) {
/* 114 */           project_isNull = false; // resultCode could change nullability.
/* 115 */           project_value = scan_value.substringSQL(1, 5);
/* 116 */
/* 117 */         }
/* 118 */         project_holder.reset();
/* 119 */
/* 120 */         project_rowWriter.zeroOutNullBytes();
/* 121 */
/* 122 */         if (project_isNull) {
/* 123 */           project_rowWriter.setNullAt(0);
/* 124 */         } else {
/* 125 */           project_rowWriter.write(0, project_value);
/* 126 */         }
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
