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
/* 028 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 029 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 031 */   private UnsafeRow bhj_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 034 */   private UnsafeRow project_result1;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 037 */
/* 038 */   public GeneratedIterator(Object[] references) {
/* 039 */     this.references = references;
/* 040 */   }
/* 041 */
/* 042 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 043 */     partitionIndex = index;
/* 044 */     this.inputs = inputs;
/* 045 */     wholestagecodegen_init_0();
/* 046 */     wholestagecodegen_init_1();
/* 047 */
/* 048 */   }
/* 049 */
/* 050 */   private void wholestagecodegen_init_0() {
/* 051 */     scan_input = inputs[0];
/* 052 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 053 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 054 */     scan_scanTime1 = 0;
/* 055 */     scan_batch = null;
/* 056 */     scan_batchIdx = 0;
/* 057 */     scan_colInstance0 = null;
/* 058 */     scan_colInstance1 = null;
/* 059 */     scan_colInstance2 = null;
/* 060 */     scan_colInstance3 = null;
/* 061 */     scan_result = new UnsafeRow(4);
/* 062 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 063 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 064 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 065 */     filter_result = new UnsafeRow(4);
/* 066 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 067 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 068 */     project_result = new UnsafeRow(4);
/* 069 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 070 */
/* 071 */   }
/* 072 */
/* 073 */   private void scan_nextBatch() throws java.io.IOException {
/* 074 */     long getBatchStart = System.nanoTime();
/* 075 */     if (scan_input.hasNext()) {
/* 076 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 077 */       scan_numOutputRows.add(scan_batch.numRows());
/* 078 */       scan_batchIdx = 0;
/* 079 */       scan_colInstance0 = scan_batch.column(0);
/* 080 */       scan_colInstance1 = scan_batch.column(1);
/* 081 */       scan_colInstance2 = scan_batch.column(2);
/* 082 */       scan_colInstance3 = scan_batch.column(3);
/* 083 */
/* 084 */     }
/* 085 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 086 */   }
/* 087 */
/* 088 */   private void wholestagecodegen_init_1() {
/* 089 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 090 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 091 */
/* 092 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 093 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 094 */
/* 095 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 096 */     bhj_result = new UnsafeRow(5);
/* 097 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 098 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 5);
/* 099 */     project_result1 = new UnsafeRow(3);
/* 100 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 101 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 3);
/* 102 */
/* 103 */   }
/* 104 */
/* 105 */   protected void processNext() throws java.io.IOException {
/* 106 */     if (scan_batch == null) {
/* 107 */       scan_nextBatch();
/* 108 */     }
/* 109 */     while (scan_batch != null) {
/* 110 */       int scan_numRows = scan_batch.numRows();
/* 111 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 112 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 113 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 114 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 115 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 116 */
/* 117 */         if (!(!(scan_isNull1))) continue;
/* 118 */
/* 119 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 120 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 121 */
/* 122 */         if (!(!(scan_isNull))) continue;
/* 123 */
/* 124 */         filter_numOutputRows.add(1);
/* 125 */
/* 126 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 127 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 128 */
/* 129 */         // generate join key for stream side
/* 130 */
/* 131 */         boolean bhj_isNull = scan_isNull3;
/* 132 */         long bhj_value = -1L;
/* 133 */         if (!scan_isNull3) {
/* 134 */           bhj_value = (long) scan_value3;
/* 135 */         }
/* 136 */         // find matches from HashedRelation
/* 137 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 138 */         if (bhj_matched == null) continue;
/* 139 */
/* 140 */         bhj_numOutputRows.add(1);
/* 141 */
/* 142 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 143 */         double scan_value2 = scan_isNull2 ? -1.0 : (scan_colInstance2.getDouble(scan_rowIdx));
/* 144 */         project_rowWriter1.zeroOutNullBytes();
/* 145 */
/* 146 */         if (scan_isNull2) {
/* 147 */           project_rowWriter1.setNullAt(0);
/* 148 */         } else {
/* 149 */           project_rowWriter1.write(0, scan_value2);
/* 150 */         }
/* 151 */
/* 152 */         project_rowWriter1.write(1, scan_value1);
/* 153 */
/* 154 */         project_rowWriter1.write(2, scan_value);
/* 155 */         append(project_result1);
/* 156 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 157 */       }
/* 158 */       scan_batchIdx = scan_numRows;
/* 159 */       scan_batch = null;
/* 160 */       scan_nextBatch();
/* 161 */     }
/* 162 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 163 */     scan_scanTime1 = 0;
/* 164 */   }
/* 165 */ }
