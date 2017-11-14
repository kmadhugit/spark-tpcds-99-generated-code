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
/* 018 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 019 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 020 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 021 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 022 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance8;
/* 023 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance9;
/* 024 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance10;
/* 025 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance11;
/* 026 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance12;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance13;
/* 028 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance14;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance15;
/* 030 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance16;
/* 031 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance17;
/* 032 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance18;
/* 033 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance19;
/* 034 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance20;
/* 035 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance21;
/* 036 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance22;
/* 037 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance23;
/* 038 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance24;
/* 039 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance25;
/* 040 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance26;
/* 041 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance27;
/* 042 */   private UnsafeRow scan_result;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 045 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 046 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 047 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 048 */   private UnsafeRow bhj_result;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 051 */   private UnsafeRow project_result;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 054 */
/* 055 */   public GeneratedIterator(Object[] references) {
/* 056 */     this.references = references;
/* 057 */   }
/* 058 */
/* 059 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 060 */     partitionIndex = index;
/* 061 */     this.inputs = inputs;
/* 062 */     wholestagecodegen_init_0();
/* 063 */     wholestagecodegen_init_1();
/* 064 */
/* 065 */   }
/* 066 */
/* 067 */   private void wholestagecodegen_init_0() {
/* 068 */     scan_input = inputs[0];
/* 069 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 070 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 071 */     scan_scanTime1 = 0;
/* 072 */     scan_batch = null;
/* 073 */     scan_batchIdx = 0;
/* 074 */     scan_colInstance0 = null;
/* 075 */     scan_colInstance1 = null;
/* 076 */     scan_colInstance2 = null;
/* 077 */     scan_colInstance3 = null;
/* 078 */     scan_colInstance4 = null;
/* 079 */     scan_colInstance5 = null;
/* 080 */     scan_colInstance6 = null;
/* 081 */     scan_colInstance7 = null;
/* 082 */     scan_colInstance8 = null;
/* 083 */     scan_colInstance9 = null;
/* 084 */     scan_colInstance10 = null;
/* 085 */     scan_colInstance11 = null;
/* 086 */     scan_colInstance12 = null;
/* 087 */     scan_colInstance13 = null;
/* 088 */     scan_colInstance14 = null;
/* 089 */     scan_colInstance15 = null;
/* 090 */     scan_colInstance16 = null;
/* 091 */     scan_colInstance17 = null;
/* 092 */     scan_colInstance18 = null;
/* 093 */     scan_colInstance19 = null;
/* 094 */     scan_colInstance20 = null;
/* 095 */     scan_colInstance21 = null;
/* 096 */     scan_colInstance22 = null;
/* 097 */     scan_colInstance23 = null;
/* 098 */     scan_colInstance24 = null;
/* 099 */     scan_colInstance25 = null;
/* 100 */     scan_colInstance26 = null;
/* 101 */     scan_colInstance27 = null;
/* 102 */     scan_result = new UnsafeRow(28);
/* 103 */
/* 104 */   }
/* 105 */
/* 106 */   private void scan_nextBatch() throws java.io.IOException {
/* 107 */     long getBatchStart = System.nanoTime();
/* 108 */     if (scan_input.hasNext()) {
/* 109 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 110 */       scan_numOutputRows.add(scan_batch.numRows());
/* 111 */       scan_batchIdx = 0;
/* 112 */       scan_colInstance0 = scan_batch.column(0);
/* 113 */       scan_colInstance1 = scan_batch.column(1);
/* 114 */       scan_colInstance2 = scan_batch.column(2);
/* 115 */       scan_colInstance3 = scan_batch.column(3);
/* 116 */       scan_colInstance4 = scan_batch.column(4);
/* 117 */       scan_colInstance5 = scan_batch.column(5);
/* 118 */       scan_colInstance6 = scan_batch.column(6);
/* 119 */       scan_colInstance7 = scan_batch.column(7);
/* 120 */       scan_colInstance8 = scan_batch.column(8);
/* 121 */       scan_colInstance9 = scan_batch.column(9);
/* 122 */       scan_colInstance10 = scan_batch.column(10);
/* 123 */       scan_colInstance11 = scan_batch.column(11);
/* 124 */       scan_colInstance12 = scan_batch.column(12);
/* 125 */       scan_colInstance13 = scan_batch.column(13);
/* 126 */       scan_colInstance14 = scan_batch.column(14);
/* 127 */       scan_colInstance15 = scan_batch.column(15);
/* 128 */       scan_colInstance16 = scan_batch.column(16);
/* 129 */       scan_colInstance17 = scan_batch.column(17);
/* 130 */       scan_colInstance18 = scan_batch.column(18);
/* 131 */       scan_colInstance19 = scan_batch.column(19);
/* 132 */       scan_colInstance20 = scan_batch.column(20);
/* 133 */       scan_colInstance21 = scan_batch.column(21);
/* 134 */       scan_colInstance22 = scan_batch.column(22);
/* 135 */       scan_colInstance23 = scan_batch.column(23);
/* 136 */       scan_colInstance24 = scan_batch.column(24);
/* 137 */       scan_colInstance25 = scan_batch.column(25);
/* 138 */       scan_colInstance26 = scan_batch.column(26);
/* 139 */       scan_colInstance27 = scan_batch.column(27);
/* 140 */
/* 141 */     }
/* 142 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 143 */   }
/* 144 */
/* 145 */   private void wholestagecodegen_init_1() {
/* 146 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 384);
/* 147 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 28);
/* 148 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[2];
/* 149 */
/* 150 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 151 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 152 */
/* 153 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 154 */     bhj_result = new UnsafeRow(28);
/* 155 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 384);
/* 156 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 28);
/* 157 */     project_result = new UnsafeRow(1);
/* 158 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 159 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 160 */
/* 161 */   }
/* 162 */
/* 163 */   protected void processNext() throws java.io.IOException {
/* 164 */     if (scan_batch == null) {
/* 165 */       scan_nextBatch();
/* 166 */     }
/* 167 */     while (scan_batch != null) {
/* 168 */       int scan_numRows = scan_batch.numRows();
/* 169 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 170 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 171 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 172 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 173 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 174 */
/* 175 */         // generate join key for stream side
/* 176 */
/* 177 */         boolean bhj_isNull = scan_isNull4;
/* 178 */         long bhj_value = -1L;
/* 179 */         if (!scan_isNull4) {
/* 180 */           bhj_value = (long) scan_value4;
/* 181 */         }
/* 182 */         // find matches from HashedRelation
/* 183 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 184 */         if (bhj_matched == null) continue;
/* 185 */
/* 186 */         bhj_numOutputRows.add(1);
/* 187 */
/* 188 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 189 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 190 */         project_holder.reset();
/* 191 */
/* 192 */         project_rowWriter.zeroOutNullBytes();
/* 193 */
/* 194 */         if (scan_isNull2) {
/* 195 */           project_rowWriter.setNullAt(0);
/* 196 */         } else {
/* 197 */           project_rowWriter.write(0, scan_value2);
/* 198 */         }
/* 199 */         project_result.setTotalSize(project_holder.totalSize());
/* 200 */         append(project_result);
/* 201 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 202 */       }
/* 203 */       scan_batchIdx = scan_numRows;
/* 204 */       scan_batch = null;
/* 205 */       scan_nextBatch();
/* 206 */     }
/* 207 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 208 */     scan_scanTime1 = 0;
/* 209 */   }
/* 210 */ }
