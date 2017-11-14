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
/* 036 */   private UnsafeRow scan_result;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 040 */   private UnsafeRow filter_result;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 043 */   private UnsafeRow project_result;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 046 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 047 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 048 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 049 */   private UnsafeRow bhj_result;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 052 */   private UnsafeRow project_result1;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 055 */
/* 056 */   public GeneratedIterator(Object[] references) {
/* 057 */     this.references = references;
/* 058 */   }
/* 059 */
/* 060 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 061 */     partitionIndex = index;
/* 062 */     this.inputs = inputs;
/* 063 */     wholestagecodegen_init_0();
/* 064 */     wholestagecodegen_init_1();
/* 065 */     wholestagecodegen_init_2();
/* 066 */
/* 067 */   }
/* 068 */
/* 069 */   private void wholestagecodegen_init_0() {
/* 070 */     scan_input = inputs[0];
/* 071 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 072 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 073 */     scan_scanTime1 = 0;
/* 074 */     scan_batch = null;
/* 075 */     scan_batchIdx = 0;
/* 076 */     scan_colInstance0 = null;
/* 077 */     scan_colInstance1 = null;
/* 078 */     scan_colInstance2 = null;
/* 079 */     scan_colInstance3 = null;
/* 080 */     scan_colInstance4 = null;
/* 081 */     scan_colInstance5 = null;
/* 082 */     scan_colInstance6 = null;
/* 083 */     scan_colInstance7 = null;
/* 084 */     scan_colInstance8 = null;
/* 085 */     scan_colInstance9 = null;
/* 086 */     scan_colInstance10 = null;
/* 087 */     scan_colInstance11 = null;
/* 088 */     scan_colInstance12 = null;
/* 089 */     scan_colInstance13 = null;
/* 090 */     scan_colInstance14 = null;
/* 091 */     scan_colInstance15 = null;
/* 092 */     scan_colInstance16 = null;
/* 093 */     scan_colInstance17 = null;
/* 094 */     scan_colInstance18 = null;
/* 095 */     scan_colInstance19 = null;
/* 096 */     scan_colInstance20 = null;
/* 097 */     scan_colInstance21 = null;
/* 098 */     scan_result = new UnsafeRow(22);
/* 099 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 448);
/* 100 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 22);
/* 101 */
/* 102 */   }
/* 103 */
/* 104 */   private void scan_nextBatch() throws java.io.IOException {
/* 105 */     long getBatchStart = System.nanoTime();
/* 106 */     if (scan_input.hasNext()) {
/* 107 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 108 */       scan_numOutputRows.add(scan_batch.numRows());
/* 109 */       scan_batchIdx = 0;
/* 110 */       scan_colInstance0 = scan_batch.column(0);
/* 111 */       scan_colInstance1 = scan_batch.column(1);
/* 112 */       scan_colInstance2 = scan_batch.column(2);
/* 113 */       scan_colInstance3 = scan_batch.column(3);
/* 114 */       scan_colInstance4 = scan_batch.column(4);
/* 115 */       scan_colInstance5 = scan_batch.column(5);
/* 116 */       scan_colInstance6 = scan_batch.column(6);
/* 117 */       scan_colInstance7 = scan_batch.column(7);
/* 118 */       scan_colInstance8 = scan_batch.column(8);
/* 119 */       scan_colInstance9 = scan_batch.column(9);
/* 120 */       scan_colInstance10 = scan_batch.column(10);
/* 121 */       scan_colInstance11 = scan_batch.column(11);
/* 122 */       scan_colInstance12 = scan_batch.column(12);
/* 123 */       scan_colInstance13 = scan_batch.column(13);
/* 124 */       scan_colInstance14 = scan_batch.column(14);
/* 125 */       scan_colInstance15 = scan_batch.column(15);
/* 126 */       scan_colInstance16 = scan_batch.column(16);
/* 127 */       scan_colInstance17 = scan_batch.column(17);
/* 128 */       scan_colInstance18 = scan_batch.column(18);
/* 129 */       scan_colInstance19 = scan_batch.column(19);
/* 130 */       scan_colInstance20 = scan_batch.column(20);
/* 131 */       scan_colInstance21 = scan_batch.column(21);
/* 132 */
/* 133 */     }
/* 134 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 135 */   }
/* 136 */
/* 137 */   private void wholestagecodegen_init_2() {
/* 138 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 22);
/* 139 */     project_result1 = new UnsafeRow(2);
/* 140 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 141 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 2);
/* 142 */
/* 143 */   }
/* 144 */
/* 145 */   private void wholestagecodegen_init_1() {
/* 146 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 147 */     filter_result = new UnsafeRow(22);
/* 148 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 448);
/* 149 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 22);
/* 150 */     project_result = new UnsafeRow(22);
/* 151 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 448);
/* 152 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 22);
/* 153 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 154 */
/* 155 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 156 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 157 */
/* 158 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 159 */     bhj_result = new UnsafeRow(22);
/* 160 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 448);
/* 161 */
/* 162 */   }
/* 163 */
/* 164 */   protected void processNext() throws java.io.IOException {
/* 165 */     if (scan_batch == null) {
/* 166 */       scan_nextBatch();
/* 167 */     }
/* 168 */     while (scan_batch != null) {
/* 169 */       int scan_numRows = scan_batch.numRows();
/* 170 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 171 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 172 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 173 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 174 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 175 */
/* 176 */         if (!(!(scan_isNull))) continue;
/* 177 */
/* 178 */         filter_numOutputRows.add(1);
/* 179 */
/* 180 */         boolean scan_isNull13 = scan_colInstance13.isNullAt(scan_rowIdx);
/* 181 */         int scan_value13 = scan_isNull13 ? -1 : (scan_colInstance13.getInt(scan_rowIdx));
/* 182 */
/* 183 */         // generate join key for stream side
/* 184 */
/* 185 */         boolean bhj_isNull = scan_isNull13;
/* 186 */         long bhj_value = -1L;
/* 187 */         if (!scan_isNull13) {
/* 188 */           bhj_value = (long) scan_value13;
/* 189 */         }
/* 190 */         // find matches from HashRelation
/* 191 */         scala.collection.Iterator bhj_matches = bhj_isNull ? null : (scala.collection.Iterator)bhj_relation.get(bhj_value);
/* 192 */         if (bhj_matches == null) continue;
/* 193 */         boolean bhj_found = false;
/* 194 */         while (!bhj_found && bhj_matches.hasNext()) {
/* 195 */           UnsafeRow bhj_matched = (UnsafeRow) bhj_matches.next();
/* 196 */
/* 197 */           bhj_found = true;
/* 198 */         }
/* 199 */         if (!bhj_found) continue;
/* 200 */         bhj_numOutputRows.add(1);
/* 201 */
/* 202 */         project_rowWriter1.zeroOutNullBytes();
/* 203 */
/* 204 */         project_rowWriter1.write(0, scan_value);
/* 205 */
/* 206 */         if (scan_isNull13) {
/* 207 */           project_rowWriter1.setNullAt(1);
/* 208 */         } else {
/* 209 */           project_rowWriter1.write(1, scan_value13);
/* 210 */         }
/* 211 */         append(project_result1);
/* 212 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 213 */       }
/* 214 */       scan_batchIdx = scan_numRows;
/* 215 */       scan_batch = null;
/* 216 */       scan_nextBatch();
/* 217 */     }
/* 218 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 219 */     scan_scanTime1 = 0;
/* 220 */   }
/* 221 */ }
